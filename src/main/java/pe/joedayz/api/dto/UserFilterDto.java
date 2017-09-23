package pe.joedayz.api.dto;

import pe.joedayz.api.enums.RoleEnum;

import java.io.Serializable;


public class UserFilterDto extends PageableFilter  implements Serializable {


    private String userName;
    private String firstName;
    private String lastName;

    private RoleEnum role;
    private String name;

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


}
