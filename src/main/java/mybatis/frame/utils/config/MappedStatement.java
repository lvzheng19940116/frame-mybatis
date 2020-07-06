package mybatis.frame.utils.config;


import lombok.Data;
import mybatis.frame.utils.sqlsource.iface.SqlSource;

@Data
public class MappedStatement {
    private String statementId;

    private String resultType;

    private Class resultClass;

    private String statementType;

    private SqlSource sqlSource;

    public MappedStatement(String statementId, Class resultClass, String statementType, SqlSource sqlSource) {
        this.statementId = statementId;
        this.resultClass = resultClass;
        this.statementType = statementType;
        this.sqlSource = sqlSource;
    }


    public Class getResultClass() {
        return resultClass;
    }

    public void setResultClass(Class resultClass) {
        this.resultClass = resultClass;
    }
}
