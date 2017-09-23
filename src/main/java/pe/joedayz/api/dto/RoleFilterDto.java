package pe.joedayz.api.dto;

/**
 * Created by josediaz on 17/08/2016.
 */
public class RoleFilterDto extends PageableFilter {

    private String roleName;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
