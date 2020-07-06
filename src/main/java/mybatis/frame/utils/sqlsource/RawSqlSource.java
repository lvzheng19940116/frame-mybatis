package mybatis.frame.utils.sqlsource;

import mybatis.frame.utils.sqlnode.DynamicContext;
import mybatis.frame.utils.sqlnode.iface.SqlNode;
import mybatis.frame.utils.sqlsource.iface.SqlSource;
import mybatis.frame.utils.sqlsource.model.BoundSql;
import mybatis.frame.utils.util.GenericTokenParser;
import mybatis.frame.utils.util.ParameterMappingTokenHandler;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 5:08 下午
 */
public class RawSqlSource implements SqlSource {
    /**
     * 封装的是不带有${}或者动态SQL标签的信息，比如#{}
     * 注意：#{}只需要解析一次就可以了。
     *      也就是说不能每次调用getBoundSql方法的时候，去解析SqlNode
     *      只能在构造方法中去解析SqlNode
     */

    /**
     * 其实就是StaticSqlSource
     */
    private SqlSource sqlSource;

    public RawSqlSource(SqlNode rootSqlNode) {
        // 解析#{}
        // 1.处理所有的SqlNode，合并成一条SQL语句（该语句#{}还未处理）
        DynamicContext context = new DynamicContext(null);
        rootSqlNode.apply(context);

        // 合并之后的SQL语句
        // select * from user where id = #{id}
        String sqlText = context.getSql();
        // 2.处理#{}，得到JDBC可以执行的【SQL语句】，以及解析出来的【参数信息集合】


        // 用来处理#{}中的参数
        // 2.1 、将#{}替换为?----字符串处理
        // 2.2 、将#{}里面的参数名称，比如说id，封装成ParameterMapping对象中，并添加到List集合
        ParameterMappingTokenHandler tokenHandler = new ParameterMappingTokenHandler();

        // 用来解析SQL文本中的#{}或者${}
        GenericTokenParser tokenParser = new GenericTokenParser("#{","}",tokenHandler);

        // JDBC可以直接执行的SQL语句
        String sql = tokenParser.parse(sqlText);

        // 3.将得到的SQL语句和参数信息集合，封装到StaticSqlSource里面存储
        sqlSource = new StaticSqlSource(sql,tokenHandler.getParameterMappings());
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return sqlSource.getBoundSql(param);
    }
}
