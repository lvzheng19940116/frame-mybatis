package mybatis.frame.utils.sqlsource;

import mybatis.frame.utils.sqlnode.iface.SqlNode;
import mybatis.frame.utils.sqlsource.iface.SqlSource;
import mybatis.frame.utils.sqlsource.model.BoundSql;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 5:07 下午
 */
public class DynamicSqlSource implements SqlSource {

    /**
     * 封装的是带有${}或者动态SQL标签的信息
     * 注意：${}需要每次执行SQL语句的时候，都要解析。
     *      也就是说每次调用getBoundSql方法的时候，去解析SqlNode
     */

    private SqlNode rootSqlNode;

    public DynamicSqlSource(SqlNode rootSqlNode) {
        this.rootSqlNode = rootSqlNode;
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return null;
    }
}
