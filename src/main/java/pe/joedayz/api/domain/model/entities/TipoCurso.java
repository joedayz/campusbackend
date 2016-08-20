package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;

@Entity
@Table(name = "tipo_curso")
@NamedQuery(name = "TipoCurso.findAll", query = "SELECT tc FROM TipoCurso tc")
public class TipoCurso extends AuditingEntity implements Serializable, BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_curso_id")
	private Long tipoCursoId;

	@Column(name = "code")
	private String code;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType", parameters = {
			@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum") })
	private ActiveInactiveStatusEnum status;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public void setTipoCursoId(Long tipoCursoId) {
		this.tipoCursoId = tipoCursoId;
	}


	public long getTipoCursoId() {
		return tipoCursoId;
	}

	public void setTipoCursoId(long tipoCursoId) {
		this.tipoCursoId = tipoCursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ActiveInactiveStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ActiveInactiveStatusEnum status) {
		this.status = status;
	}

	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoCursoId == null) ? 0 : tipoCursoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoCurso other = (TipoCurso) obj;
		if (tipoCursoId == null) {
			if (other.tipoCursoId != null)
				return false;
		} else if (!tipoCursoId.equals(other.tipoCursoId))
			return false;
		return true;
	}

	

}
