package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.YesNoEnum;


/**
 * The persistent class for the "MODULE" database table.
 * 
 */
@Entity
@Table(name="\"module\"")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module extends AuditingEntity implements BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="module_id")
	private long moduleId;

	private String code;

	@Column(name="help_url")
	private String helpUrl;

	@Column(name="menu_label")
	private String menuLabel;

	@Column(name="menu_order")
	private BigDecimal menuOrder;

	private String name;

	private String url;

	@Column(name="visible")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType",
			parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.YesNoEnum")})
	private YesNoEnum visible;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="parent_module_id")
	private Module module;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="module")
	private List<Module> modules = new ArrayList<>();

	//bi-directional many-to-one association to Permission
	@OneToMany(mappedBy="module")
	private List<Permission> permissions;

	public Module() {
	}

	public long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHelpUrl() {
		return this.helpUrl;
	}

	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}

	public String getMenuLabel() {
		return this.menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public BigDecimal getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(BigDecimal menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public YesNoEnum getVisible() {
		return visible;
	}

	public void setVisible(YesNoEnum visible) {
		this.visible = visible;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Module> getModules() {
		return this.modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Module addModule(Module module) {
		getModules().add(module);
		module.setModule(this);

		return module;
	}

	public Module removeModule(Module module) {
		getModules().remove(module);
		module.setModule(null);

		return module;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Permission addPermission(Permission permission) {
		getPermissions().add(permission);
		permission.setModule(this);

		return permission;
	}

	public Permission removePermission(Permission permission) {
		getPermissions().remove(permission);
		permission.setModule(null);

		return permission;
	}


}