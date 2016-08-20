package pe.joedayz.api.dto;

/**
 * Created by josediaz on 17/08/2016.
 */
public class GeneralTableFilterDto extends PageableFilter {

    private String tableName;
    private String code;

    private Long validateNotGeneralTableId;

    public Long getValidateNotGeneralTableId() {
        return validateNotGeneralTableId;
    }

    public void setValidateNotGeneralTableId(Long validateNotGeneralTableId) {
        this.validateNotGeneralTableId = validateNotGeneralTableId;
    }

    public String getGroup() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
