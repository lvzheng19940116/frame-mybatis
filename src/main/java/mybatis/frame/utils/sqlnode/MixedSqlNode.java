package mybatis.frame.utils.sqlnode;


import mybatis.frame.utils.sqlnode.iface.SqlNode;

import java.util.List;

/**
 *@author LvZheng
 * 创建时间：2020/7/3 3:59 下午
 */
public class MixedSqlNode implements SqlNode {

    private List<SqlNode> sqlNodes;

    public MixedSqlNode(List<SqlNode> sqlNodes) {
        this.sqlNodes = sqlNodes;
    }

    @Override
    public void apply(DynamicContext context) {

    }
}
