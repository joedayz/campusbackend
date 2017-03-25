package pe.joedayz.api.dto;

/**
 * Created by MATRIX-JAVA on 16/5/2016.
 */
public class JsonResult {
    private String status="OK";
    private String description="";
    private int created=0;
    private int updated=0;
    private int deleted=0;
    private int error=0;
    private int processed=0;

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public boolean isChange() {
        return (updated+deleted+created)>0;
    }
    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }
}
