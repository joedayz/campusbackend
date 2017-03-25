package pe.joedayz.api.dto;

import pe.joedayz.api.enums.RoleEnum;

import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.toList;

public class UserDto {

    private Long id;
    private String name;
    private String userName;
    private String firstName;
    private String lastName;
    private String status;

    private String fullName;

    private String password;

    private String title;
    private String email;
    private String confirmPassword;
    private String newPassword;


    List<RolDto> rolList = new ArrayList<>();

    List<RoleViewDto> roleList = new ArrayList<>();

    public boolean hasAny(List<RoleEnum> roles) {
        List<String> codeRoles = roles.stream().map(r -> r.getCode()).collect(toList());
        return hasRole(codeRoles.toArray(new String[codeRoles.size()]));
    }

    protected boolean hasRole(String[] roles) {
        boolean result = false;
        for (RolDto authority : rolList) {
            String userRole = authority.getCode();
            for (String role : roles) {
                if (role.equals(userRole)) {
                    result = true;
                    break;
                }
            }

            if (result) {
                break;
            }
        }

        return result;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addRol(RolDto rolDto) {
        rolList.add(rolDto);
    }

    public List<RolDto> getRolList() {
        return rolList;
    }

    public void setRolList(List<RolDto> rolList) {
        this.rolList = rolList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public List<RoleViewDto> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleViewDto> roleList) {
        this.roleList = roleList;
    }
}
