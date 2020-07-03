package mybatis.frame.utils.sqlnode;


import mybatis.frame.utils.sqlnode.iface.SqlNode;

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

    }

    /**
     * 判断封装的SQL文本是否带有${}
     *
     * @return
     */
    public boolean isDynamic() {
        return (sqlText.indexOf("${") > -1);
    }
}
