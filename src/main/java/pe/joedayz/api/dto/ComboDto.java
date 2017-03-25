package pe.joedayz.api.dto;

import java.math.BigDecimal;

/**
 * Created by awusr on 31/05/2016.
 */
public class ComboDto {

    private String name;
    private String code;
    private BigDecimal order;
    private String tableName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getOrder() {
        return order;
    }

    public void setOrder(BigDecimal order) {
        this.order = order;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
