package pe.joedayz.api.dto;

import java.math.BigDecimal;
import java.util.List;

public class ModuleDto {
    protected long moduleId;

    private String code;

    private String helpUrl;

    private String menuLabel;

    private BigDecimal menuOrder;

    private String name;

    private String url;

    private String permissionType;

    private String visible;

    private List<ModuleDto> subModules;

    public ModuleDto() {
    }

    public ModuleDto(long moduleId, String code, String helpUrl, String menuLabel, BigDecimal menuOrder, String name, String url) {
        this.moduleId = moduleId;
        this.code = code;
        this.helpUrl = helpUrl;
        this.menuLabel = menuLabel;
        this.menuOrder = menuOrder;
        this.name = name;
        this.url = url;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHelpUrl() {
        return helpUrl;
    }

    public void setHelpUrl(String helpUrl) {
        this.helpUrl = helpUrl;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public BigDecimal getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(BigDecimal menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ModuleDto> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<ModuleDto> subModules) {
        this.subModules = subModules;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleDto moduleDto = (ModuleDto) o;

        return moduleId == moduleDto.moduleId;

    }

    @Override
    public int hashCode() {
        return (int) (moduleId ^ (moduleId >>> 32));
    }

    @Override
    public String toString() {
        return "ModuleDto{" +
                "moduleId=" + moduleId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
