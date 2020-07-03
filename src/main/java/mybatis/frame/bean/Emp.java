package mybatis.frame.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Emp {
    /**
     * id
     */
    private Integer eid;

    /**
     *  名称
     */
    private String name;

    /**
     *  身价
     */
    private BigDecimal money;

    /**
     * 功夫
     */
    private String effort;

    /**
     * 门派
     */
    private String sect;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 日期
     */
    private Date date1;

    /**
     * 日期
     */
    private Date date2;


}