package mybatis.frame.utils.sqlsource;

import mybatis.frame.utils.sqlnode.iface.SqlNode;
import mybatis.frame.utils.sqlsource.iface.SqlSource;
import mybatis.frame.utils.sqlsource.model.BoundSql;

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
        //TODO 解析#{}
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return sqlSource.getBoundSql(param);
    }
}
