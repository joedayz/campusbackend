package pe.joedayz.api.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by josediaz on 17/08/2016.
 */
public class ModuleViewDto {

    private String parentCode;
    private String parentName;
    private Long moduleId;
    private String name;
    private String code;
    private PermissionTypeDto permissionType= new PermissionTypeDto();
    private String visible;

    private String menuLabel;
    private BigDecimal menuOrder;
    private String url;
    private String helpUrl;
    private Long parentModuleId;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private Integer rowVersion;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PermissionTypeDto getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionTypeDto permissionType) {
        this.permissionType = permissionType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHelpUrl() {
		return helpUrl;
	}

	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}

	public Long getParentModuleId() {
		return parentModuleId;
	}

	public void setParentModuleId(Long parentModuleId) {
		this.parentModuleId = parentModuleId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getRowVersion() {
		return rowVersion;
	}

	public void setRowVersion(Integer rowVersion) {
		this.rowVersion = rowVersion;
	}

	@Override
    public String toString() {
        return "ModuleDto{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", permissionType='" + permissionType + '\'' +
                '}';
    }


}
