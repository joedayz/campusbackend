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
@Table(name = "portada")
@NamedQuery(name = "Portada.findAll", query = "SELECT p FROM Portada p")
public class Portada extends AuditingEntity implements Serializable, BaseEntity {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portada_id")
	private Long portadaId;
	
	
    
	@Column(name = "titulo_foto", nullable=true, length=100)
	private String tituloFoto;
	
	@Column(name = "descripcion_foto", nullable=true, length=150)
	private String descripcionFoto;
	
	@Column(name = "url_foto", nullable=false, length=200)
	private String urlFoto;
	
	
	
	@Column(name = "status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType", parameters = {
			@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum") })
	private ActiveInactiveStatusEnum status;


	public Long getPortadaId() {
		return portadaId;
	}

	public void setPortadaId(Long portadaId) {
		this.portadaId = portadaId;
	}

	public String getTituloFoto() {
		return tituloFoto;
	}

	public void setTituloFoto(String tituloFoto) {
		this.tituloFoto = tituloFoto;
	}

	public String getDescripcionFoto() {
		return descripcionFoto;
	}

	public void setDescripcionFoto(String descripcionFoto) {
		this.descripcionFoto = descripcionFoto;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public ActiveInactiveStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ActiveInactiveStatusEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portadaId == null) ? 0 : portadaId.hashCode());
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
		Portada other = (Portada) obj;
		if (portadaId == null) {
			if (other.portadaId != null)
				return false;
		} else if (!portadaId.equals(other.portadaId))
			return false;
		return true;
	}


	


}
