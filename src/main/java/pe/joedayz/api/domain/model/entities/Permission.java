package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.PermissionTypeEnum;

/**
 * The persistent class for the PERMISSION database table.
 * 
 */
@Entity
@Table(name = "permission")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission extends AuditingEntity implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permission_id")
	private long permissionId;


	@Column(name="PERMISSION_TYPE")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType",
			parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.PermissionTypeEnum")})
	private PermissionTypeEnum permissionType;




	@ManyToOne
	@JoinColumn(name="module_id",insertable = false,updatable = false)
    private Module module;

	@ManyToOne
	@JoinColumn(name="role_id",insertable = false,updatable = false)
    private Role role;


	public long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}


	public PermissionTypeEnum getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionTypeEnum permissionType) {
		this.permissionType = permissionType;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
