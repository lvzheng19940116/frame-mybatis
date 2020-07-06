package mybatis.frame.utils.sqlnode;


import mybatis.frame.utils.sqlnode.iface.SqlNode;
import mybatis.frame.utils.util.GenericTokenParser;
import mybatis.frame.utils.util.OgnlUtils;
import mybatis.frame.utils.util.SimpleTypeRegistry;
import mybatis.frame.utils.util.TokenHandler;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 2:59 下午
 * <p>
 * 封装带有${}的SQL信息
 */
public class TextSqlNode implements SqlNode {

    /**
     * 封装未解析的sql文本信息
     */
    private String sqlText;

    public TextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext context) {
        // 用来处理${}中的参数
        // select * from user where name like '${name}%'
        // 用来解析SQL文本中的#{}或者${}
        GenericTokenParser tokenParser = new GenericTokenParser("${","}",
                //TestSqlNode 使用的类  内部类
                new BindingTokenHandler(context));

        // JDBC可以直接执行的SQL语句
        String sql = tokenParser.parse(sqlText);

        context.appendSql(sql);
    }

    /**
     * 判断封装的SQL文本是否带有${}
     *
     * @return
     */
    public boolean isDynamic() {
        return (sqlText.indexOf("${") > -1);
    }

    /**
     * TestSqlNode 使用的类  内部类
     */

    class BindingTokenHandler implements TokenHandler {

        private DynamicContext context;

        public BindingTokenHandler(DynamicContext context) {
            this.context = context;
        }

        /**
         * 使用参数值来替换${}
         * @param content 是${}中的内容
         * @return 用来替换${}的值
         */
        @Override
        public String handleToken(String content) {
            // 获取参数值
            Object parameter = context.getBindings().get("_parameter");

            if (parameter == null) {
                return "";
            }else if (SimpleTypeRegistry.isSimpleType(parameter.getClass())){
                return parameter.toString();
            }
            // POJO类型或者Map类型
            Object value = OgnlUtils.getValue(content, parameter);
            return value == null ? "":value.toString();
        }
    }
}
