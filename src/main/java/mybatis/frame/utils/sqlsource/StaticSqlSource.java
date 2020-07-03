package mybatis.frame.utils.sqlsource;

import mybatis.frame.utils.sqlsource.iface.SqlSource;
import mybatis.frame.utils.sqlsource.model.BoundSql;
import mybatis.frame.utils.sqlsource.model.ParameterMapping;

import java.util.List;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 5:10 下午
 */
public class StaticSqlSource implements SqlSource {


    /**
     * 只需要封装已经解析出来的SqlSource信息
     */
    private String sql;

    private List<ParameterMapping> parameterMappings;
    public StaticSqlSource(String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return new BoundSql(sql,parameterMappings);
    }
}
