package pe.joedayz.api.dto;

/**
 * Created by josediaz on 17/08/2016.
 */
public class ModuleViewRsl {

    private Long moduleId;
    private String code;
    private String name;
    private String menuLabel;
    private String menuOrder;
    private String visible;
    private String parentName;

    public Long getModuleId() {
        return moduleId;
    }
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMenuLabel() {
        return menuLabel;
    }
    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }
    public String getMenuOrder() {
        return menuOrder;
    }
    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }
    public String getVisible() {
        return visible;
    }
    public void setVisible(String visible) {
        this.visible = visible;
    }
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
