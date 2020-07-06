package mybatis.frame.utils.sqlnode;


import mybatis.frame.utils.sqlnode.iface.SqlNode;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 2:59 下午
 * <p>
 * 封装不带有${}的SQL信息
 */
public class StaticTextSqlNode implements SqlNode {
    /**
     * 封装未解析的sql文本信息
     */

    private String sqlText;

    public StaticTextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext context) {
        context.appendSql(sqlText);
    }
}
