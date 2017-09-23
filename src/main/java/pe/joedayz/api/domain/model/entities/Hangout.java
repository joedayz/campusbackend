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
@Table(name = "hangout")
@NamedQuery(name = "Hangout.findAll", query = "SELECT h FROM Hangout h")
public class Hangout extends AuditingEntity implements Serializable, BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hangout_id")
	private Long hangoutId;
	
	@Column(name = "titulo", nullable=false, length=200)
	private String titulo;
	
	@Column(name = "descripcion", nullable=true, length=1000)
	private String descripcion;
	
	@Column(name = "url", nullable=false, length=200)
	private String url;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;
	
	
	@Column(name = "status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType", parameters = {
			@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum") })
	private ActiveInactiveStatusEnum status;

	@Column(name = "ponente", nullable=true, length=255)
	private String ponente;



	public Long getHangoutId() {
		return hangoutId;
	}

	public void setHangoutId(Long hangoutId) {
		this.hangoutId = hangoutId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		result = prime * result + ((hangoutId == null) ? 0 : hangoutId.hashCode());
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
		Hangout other = (Hangout) obj;
		if (hangoutId == null) {
			if (other.hangoutId != null)
				return false;
		} else if (!hangoutId.equals(other.hangoutId))
			return false;
		return true;
	}

	
	

}
