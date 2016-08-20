package pe.joedayz.api.domain.model.entities;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import org.hibernate.annotations.Type;
import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;

/**
 * The persistent class for the VENDOR database table.
 * 
 */
@Entity
@NamedQuery(name="Parameter.findAll", query="SELECT v FROM Parameter v")
public class Parameter extends AuditingEntity implements Serializable, BaseEntity{
	private static final long serialVersionUID = 1L;

	@Id    
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parameter_id")
	private long parameterId;

	private String code;

	private String description;

	private String value;

	@Column(name = "status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType",
			parameters = {@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum")})
	private ActiveInactiveStatusEnum status;





	public long getParameterId() {
		return parameterId;
	}

	public void setParameterId(long parameterId) {
		this.parameterId = parameterId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ActiveInactiveStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ActiveInactiveStatusEnum status) {
		this.status = status;
	}


}