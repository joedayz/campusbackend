package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;


/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends AuditingEntity implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private long roleId;

	@Column(name="role_name")
	private String roleName;

	@Column(name="code")
	private String code;




	@Column(name="status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType",
			parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum")})
	private ActiveInactiveStatusEnum status;


	//bi-directional many-to-one association to Permission
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE,
			org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.PERSIST
	})
	private List<Permission> permissions;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Permission addPermission(Permission permission) {
		getPermissions().add(permission);
		permission.setRole(this);

		return permission;
	}

	public Permission removePermission(Permission permission) {
		getPermissions().remove(permission);
		permission.setRole(null);

		return permission;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}


	public ActiveInactiveStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ActiveInactiveStatusEnum status) {
		this.status = status;
	}
}