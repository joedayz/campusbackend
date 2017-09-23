package pe.joedayz.api.dto;


public class RolDto {

    private Long id;

    private String code;
    private String roleName;

    public RolDto() {
    }

    public RolDto(Long id) {
        this.id = id;
    }


    public RolDto(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
