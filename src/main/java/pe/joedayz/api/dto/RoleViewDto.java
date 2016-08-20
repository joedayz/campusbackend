package pe.joedayz.api.dto;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */
public class RoleViewDto {

    private Long roleId;
    private String roleCode;
    private String roleName;
    private String roleStatus;
    private String isDeleteRole;
    private String isUpdateRole;
    private String roleAccess;
    private String isEditCode;
    private List<ModuleViewDto> modules;

    public List<ModuleViewDto> getModules() {
        return modules;
    }

    public void setModules(List<ModuleViewDto> modules) {
        this.modules = modules;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleAccess() {
        return roleAccess;
    }

    public void setRoleAccess(String roleAccess) {
        this.roleAccess = roleAccess;
    }

    public String getIsDeleteRole() {
        return isDeleteRole;
    }

    public void setIsDeleteRole(String isDeleteRole) {
        this.isDeleteRole = isDeleteRole;
    }

    public String getIsUpdateRole() {
        return isUpdateRole;
    }

    public void setIsUpdateRole(String isUpdateRole) {
        this.isUpdateRole = isUpdateRole;
    }

    public String getIsEditCode() {
        return isEditCode;
    }

    public void setIsEditCode(String isEditCode) {
        this.isEditCode = isEditCode;
    }
}
