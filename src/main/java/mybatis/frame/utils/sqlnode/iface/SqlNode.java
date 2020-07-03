package mybatis.frame.utils.sqlnode.iface;


import mybatis.frame.utils.sqlnode.DynamicContext;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 2:59 下午
 *
 */
public interface SqlNode {
    /**
     * 提供对于SQL节点信息的处理功能
     * @param context
     */
    void apply(DynamicContext context);
}
