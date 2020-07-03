package mybatis.frame.utils.sqlnode;


import mybatis.frame.utils.sqlnode.iface.SqlNode;

/**
 *
 * @author LvZheng
 * 创建时间：2020/7/3 3:59 下午
 *
 * 封装if标签的SQL信息
 */
public class IfSqlNode implements SqlNode {

    /**
     * if标签的test属性
     */

    private String test;

    /**
     * if标签的子标签集合
     */
    private SqlNode rootSqlNode;

    public IfSqlNode(String test, SqlNode rootSqlNode) {
        this.test = test;
        this.rootSqlNode = rootSqlNode;
    }

    @Override
    public void apply(DynamicContext context) {

    }
}
