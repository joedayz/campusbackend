package pe.joedayz.api.dto;

import java.util.Date;

/**
 * Created by josediaz on 17/08/2016.
 */
public class GeneralTableViewRsl extends PageableFilter {

    private Long generalTableId;
    private String tableName;
    private String code;
    private String value;
    private Integer sortOrder;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private String status;

    public Long getGeneralTableId() {
        return generalTableId;
    }

    public void setGeneralTableId(Long generalTableId) {
        this.generalTableId = generalTableId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GeneralTableViewRsl{" +
                "tableName='" + tableName + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}