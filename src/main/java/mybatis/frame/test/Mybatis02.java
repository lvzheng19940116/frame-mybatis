package mybatis.frame.test;

import lombok.extern.slf4j.Slf4j;
import mybatis.frame.bean.Emp;
import mybatis.frame.utils.config.Configuration;
import mybatis.frame.utils.config.MappedStatement;
import mybatis.frame.utils.sqlnode.IfSqlNode;
import mybatis.frame.utils.sqlnode.MixedSqlNode;
import mybatis.frame.utils.sqlnode.StaticTextSqlNode;
import mybatis.frame.utils.sqlnode.TextSqlNode;
import mybatis.frame.utils.sqlnode.iface.SqlNode;
import mybatis.frame.utils.sqlsource.DynamicSqlSource;
import mybatis.frame.utils.sqlsource.RawSqlSource;
import mybatis.frame.utils.sqlsource.iface.SqlSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 12:41 下午
 * <p>
 * Java是最好的语言
 */
@Slf4j
public  class Mybatis02 {

    /**
     * 用于存储XML配置文件中的信息
     */

    private Configuration configuration = new Configuration();
    /**
     * 映射文件中配置的命名空间
     */
    private String namespace;
    /**
     * 用于标记SQL文本中是否带有$
     */
    private boolean isDynamic;


    /**
     * * 1.properties配置文件升级为XML配置文件
     * * 2.使用面向过程思维去优化代码
     */
    @Test
    public void test(){
        // 加载全局配置文件和映射文件
        loadXML("mybatis-config.xml");
        log.info("解析xml");
        // 规定selectUserList方法的参数只有 两个。
        Map param = new HashMap();
        param.put("name","吕正");
        param.put("eid","1");

        // 调用公共方法，查询用户信息
        List<Emp> emps = selectList("test.queryUserByParams",param);
        log.info("解析xml{}",emps);
    }

    /**
     * 解析XML配置文件
     * @param location
     */
    private void loadXML(String location) {
        // 根据路径获取流对象
        InputStream inputStream = getResourceAsStream(location);
        // 创建Document对象
        Document document = getDocument(inputStream);
        // 从全局配置文件的根标签开始解析<configuration>
        parseConfiguration(document.getRootElement());
    }

    /**
     * 获取输入流
     * @param location
     * @return
     */
    private InputStream getResourceAsStream(String location) {
        return this.getClass().getClassLoader().getResourceAsStream(location);
    }

    /**
     * 获取document对象
     * @param inputStream
     * @return
     */
    private Document getDocument(InputStream inputStream) {
        try {
            SAXReader saxReader = new SAXReader();
            return saxReader.read(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从全局配置文件的根标签开始解析
     * @param rootElement
     * <configuration></configuration>
     */
    private void parseConfiguration(Element rootElement) {
        Element environments = rootElement.element("environments");
        parseEnvironments(environments);

        Element mappers = rootElement.element("mappers");
        parseMappers(mappers);
    }
    /**
     * 解析全局配置文件中的environments标签
     * @param environments
     * <environments></environments>
     */
    private void parseEnvironments(Element environments) {
        String defaultValue = environments.attributeValue("default");
        List<Element> environmentList = environments.elements("environment");
        for (Element element : environmentList) {
            String id = element.attributeValue("id");
            if (defaultValue.equals(id)){
                Element dataSource = element.element("dataSource");
                parseDataSource(dataSource);
            }
        }
    }
    /**
     * 解析数据源标签
     * @param element <dataSource></dataSource>
     */
    private void parseDataSource(Element element) {
        String type = element.attributeValue("type");
        if ("DBCP".equals(type)){
            BasicDataSource dataSource = new BasicDataSource();

            Properties properties = parseProperties(element);

            dataSource.setDriverClassName(properties.getProperty("db.driver"));
            dataSource.setUrl(properties.getProperty("db.url"));
            dataSource.setUsername(properties.getProperty("db.username"));
            dataSource.setPassword(properties.getProperty("db.password"));

            configuration.setDataSource(dataSource);
        }

    }

    /**
     * 解析全局配置文件中的mappers标签
     * @param mappers
     * <mappers></mappers>
     */
    private void parseMappers(Element mappers) {
        List<Element> list = mappers.elements("mapper");
        for (Element element : list) {
            String resource = element.attributeValue("resource");
            // 根据xml的路径，获取对应的输入流
            InputStream inputStream = getResourceAsStream(resource);
            // 将流对象，转换成Document对象
            Document document = getDocument(inputStream);
            // 针对Document对象，按照Mybatis的语义去解析Document
            parseMapper(document.getRootElement());
        }
    }
    /**
     * 解析映射文件的mapper信息
     * @param rootElement <mapper></mapper>
     */
    private void parseMapper(Element rootElement) {
        namespace = rootElement.attributeValue("namespace");
        // TODO 获取动态SQL标签，比如<sql>
        // TODO 获取其他标签
        List<Element> selectElements = rootElement.elements("select");
        for (Element selectElement : selectElements) {
            parseStatementElement(selectElement);
        }
    }




    /**
     *
     * @param element dataSource标签
     * @return
     */
    private Properties parseProperties(Element element) {
        Properties properties = new Properties();
        List<Element> propertyList = element.elements("property");
        for (Element propertyElement : propertyList) {
            String name = propertyElement.attributeValue("name");
            String value = propertyElement.attributeValue("value");
            properties.put(name,value);
        }
        return properties;
    }



    /**
     * 解析映射文件中的select标签
     * @param selectElement <select></select>
     */
    private void parseStatementElement(Element selectElement) {
        String statementId = selectElement.attributeValue("id");

        if (statementId == null || statementId.equals("")) {
            return;
        }
        // 一个CURD标签对应一个MappedStatement对象
        // 一个MappedStatement对象由一个statementId来标识，所以保证唯一性
        // statementId = namespace + "." + CRUD标签的id属性
        statementId = namespace + "." + statementId;

        // 注意：parameterType参数可以不设置也可以不解析
      /*  String parameterType = selectElement.attributeValue("parameterType");
        Class<?> parameterClass = resolveType(parameterType);*/

        String resultType = selectElement.attributeValue("resultType");
        Class<?> resultClass = resolveType(resultType);

        String statementType = selectElement.attributeValue("statementType");
        statementType = statementType == null || statementType == "" ? "prepared" : statementType;

        //TODO SqlSource和SqlNode的封装过程
        SqlSource sqlSource = createSqlSource(selectElement);

        // TODO 建议使用构建者模式去优化
        MappedStatement mappedStatement = new MappedStatement(statementId, resultClass, statementType,
                sqlSource);
        configuration.addMappedStatement(statementId, mappedStatement);
    }
    private SqlSource createSqlSource(Element selectElement) {
        //TODO 其他子标签的解析处理

        SqlSource sqlSource = parseScriptNode(selectElement);

        return sqlSource;
    }
    private SqlSource parseScriptNode(Element selectElement) {
        //解析动态标签
        SqlNode mixedSqlNode = parseDynamicTags(selectElement);

        SqlSource sqlSource;
        //如果带有${}或者动态SQL标签
        if (isDynamic){
            sqlSource = new DynamicSqlSource(mixedSqlNode);
        }else{
            sqlSource = new RawSqlSource(mixedSqlNode);
        }
        return sqlSource;
    }

    private SqlNode parseDynamicTags(Element selectElement) {
        List<SqlNode> sqlNodes = new ArrayList<>();

        //获取select标签的子元素 ：文本类型或者Element类型
        int nodeCount = selectElement.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            Node node = selectElement.node(i);
            if (node instanceof Text){
                String text = node.getText();
                if (text==null){
                    continue;
                }
                if ("".equals(text.trim())){
                    continue;
                }
                // 先将sql文本封装到TextSqlNode中
                TextSqlNode textSqlNode = new TextSqlNode(text.trim());
                if (textSqlNode.isDynamic()){
                    sqlNodes.add(textSqlNode);
                    isDynamic = true;
                }else{
                    sqlNodes.add(new StaticTextSqlNode(text.trim()));
                }

            }else if (node instanceof Element){
                isDynamic = true;
                Element element  = (Element) node;
                String name = element.getName();

                if ("if".equals(name)){
                    String test = element.attributeValue("test");
                    //递归去解析子元素
                    SqlNode sqlNode = parseDynamicTags(element);

                    IfSqlNode ifSqlNode = new IfSqlNode(test,sqlNode);
                    sqlNodes.add(ifSqlNode);
                }else{
                    // TODO
                }
            }else{
                //TODO
            }
        }
        return new MixedSqlNode(sqlNodes);
    }

    /**
     * 根据全限定名获取Class对象
     * @param parameterType
     * @return
     */
    private Class<?> resolveType(String parameterType) {
        try {
            Class<?> clazz = Class.forName(parameterType);
            return clazz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 执行查询的逻辑代码
     * @param statementId
     * @param param
     * @param <T>
     * @return
     */
    private <T> List<T> selectList(String statementId,Object param) {
        List<T> results = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            MappedStatement mappedStatement = configuration.getMappedStatementById(statementId);

            // 1.获取连接
            connection = getConnection();

            // TODO 2.获取SQL语句(SqlSource和SqlNode的执行过程)
            String sql = getSql();
            // 3.创建Statement对象
            statement = createStatement(connection,sql,mappedStatement);

            // TODO 4.设置参数
            setParameters(statement,param);

            // 5.执行Statement
            rs = handleStatement(statement);

            // 6.处理ResultSet
            handleResultSet(rs,results,mappedStatement);
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return  null;
    }
    /**
     * 获取连接的代码
     * @return
     */
    private Connection getConnection(){
        // 优化连接处理
        try {
            DataSource dataSource = configuration.getDataSource();
            return dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private String getSql() {
        return null;
    }
    /**
     * 创建Statement对象
     * @param connection
     * @param sql
     * @param mappedStatement
     * @return
     * @throws Exception
     */
    private Statement createStatement(Connection connection, String sql, MappedStatement mappedStatement) throws Exception{
        String statementType = mappedStatement.getStatementType();
        if (statementType.equals("prepared")){
            return connection.prepareStatement(sql);
        }else if (statementType.equals("statement")){
            return connection.createStatement();
        }else if (statementType.equals("callable")){
            //TODO
        }else{
            //TODO
        }
        return null;
    }

    /**
     * 设置参数
     * @param statement
     * @param param
     * @throws Exception
     */
    private void setParameters(Statement statement, Object param) throws Exception{
        if (statement instanceof PreparedStatement){
            PreparedStatement preparedStatement = (PreparedStatement) statement;
            if (param instanceof Integer || param instanceof String){
                preparedStatement.setObject(1, param);
            }else if (param instanceof Map){
                // TODO 结合#{}的处理逻辑进行改造

            }else{
                //TODO
            }
        }
    }


    /**
     * 执行Statement
     * @param statement
     * @return
     * @throws Exception
     */
    private ResultSet handleStatement(Statement statement) throws Exception{
        if (statement instanceof PreparedStatement) {
            PreparedStatement preparedStatement = (PreparedStatement) statement;
            return preparedStatement.executeQuery();
        }
        return null;
    }

    /**
     * 处理结果集
     * @param rs
     * @param results
     * @param mappedStatement
     * @param <T>
     * @throws Exception
     */
    private <T> void handleResultSet(ResultSet rs, List<T> results, MappedStatement mappedStatement) throws Exception{
        // 遍历查询结果集
        Class clazz= mappedStatement.getResultClass();

        Object result = null;
        while (rs.next()) {
            result = clazz.newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                // 取出resultset中的每一行结果中的列的名称
                String columnName = metaData.getColumnName(i);
                // 要求列的名称和映射 对象的属性名称要一致
                Field field = clazz.getDeclaredField(columnName);
                // 暴力访问私有成员
                field.setAccessible(true);
                field.set(result,rs.getObject(i));
            }

            results.add((T) result);
        }
    }

}
