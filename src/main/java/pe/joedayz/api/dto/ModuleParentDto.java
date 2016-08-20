package pe.joedayz.api.dto;

import java.math.BigDecimal;

public class ModuleParentDto extends  ModuleDto {
    private String parentCode;
    private String parentName;

    public ModuleParentDto() {
    }

    public ModuleParentDto(String parentCode, String parentName, long moduleId, String code, String helpUrl, String menuLabel, BigDecimal menuOrder, String name, String url) {
        super(moduleId, code, helpUrl, menuLabel, menuOrder, name, url);
        this.parentCode = parentCode;
        this.parentName = parentName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ModuleParentDto that = (ModuleParentDto) o;

        if (!parentCode.equals(that.parentCode)) return false;
        return moduleId  == that.moduleId;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + parentCode.hashCode();
        result = 31 * result + Long.hashCode(moduleId);
        return result;
    }

    @Override
    public String toString() {
        return "ModuleParentDto{" +
                "parentCode='" + parentCode + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
