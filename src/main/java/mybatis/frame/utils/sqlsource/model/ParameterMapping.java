package mybatis.frame.utils.sqlsource.model;

import lombok.Data;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 4:52 下午
 *
 * 封装#{}解析出来的参数信息
 *
 */
@Data
public class ParameterMapping {
    /**
     * #{}中的参数名称
     */
    private  String name;
    /**
     * #{}对于的参数的参数类型
     */
    private  Class type;

}
