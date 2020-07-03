package mybatis.frame.utils.sqlsource.iface;

import mybatis.frame.utils.sqlsource.model.BoundSql;

/**
 * @author LvZheng
 * 创建时间：2020/7/3 4:51 下午
 *
 * 提供对封装的SQL信息进行处理的操作
 *
 */
public interface SqlSource {
    /**
     * 提供对封装的SQL信息进行处理的操作
     * @param param
     * @return
     */
    BoundSql getBoundSql(Object param) ;
}
