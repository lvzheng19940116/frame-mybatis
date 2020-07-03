package mybatis.frame.utils.sqlnode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 5:17 下午
 *
 * 用来封装SqlNode执行过程中需要的参数信息以及用来拼接SqlNode执行过程中的SQL文本
 *
 */
public class DynamicContext {

    /**
     * 用于拼接SQL语句的StringBuffer对象
      */
    private StringBuffer sb = new StringBuffer();

    /**
     * 用于封装解析SqlNode过程中需要的信息
     */
    private Map<String,Object> bindings = new HashMap<>();

    //必须传入参
    public DynamicContext(Object param) {
        bindings.put("_parameter",param);
    }

    //获取最终合并后的sql文本信息
    public String getSql(){
        return sb.toString();
    }

    //SQL文本拼接
    public void appendSql(String sql)   {
        sb.append(sql);
        sb.append(" ");
    }

    public Map<String, Object> getBindings() {
        return bindings;
    }

    public void addBinding(String key, Object value) {
        this.bindings.put(key,value);
    }
}
