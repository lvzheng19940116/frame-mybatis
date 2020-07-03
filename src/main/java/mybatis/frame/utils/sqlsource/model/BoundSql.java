package mybatis.frame.utils.sqlsource.model;

import lombok.Data;

import java.util.List;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 4:55 下午
 *
 * 用于封装解析之后的sql语句以及#{}解析出来的参数集合信息
 *
 */
@Data
public class BoundSql {
    /**
     * 封装解析之后的sql语句
     */
    private  String sql;
    /**
     * #{}解析出来的参数集合信息
     */
    private List<ParameterMapping> parameterMappings;

    public BoundSql(String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
    }

}
