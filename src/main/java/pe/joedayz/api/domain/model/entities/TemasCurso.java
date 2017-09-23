package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;

@Entity
@Table(name = "temas_curso")
@NamedQuery(name = "TemasCurso.findAll", query = "SELECT tc FROM TemasCurso tc")
public class TemasCurso extends AuditingEntity implements Serializable, BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "temas_curso_id")
	private Long temasCursoId;

	@Column(name = "titulo", nullable = false, length = 200)
	private String titulo;

	@Column(name = "descripcion", nullable = false, length = 600)
	private String descripcion;

	
	@Column(name = "url", nullable = false, length = 200)
	private String url;
	
	@Column(name="tema_orden")
	private BigDecimal temaOrden;
	
	
	@Column(name = "status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType", parameters = {
			@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum") })
	private ActiveInactiveStatusEnum status;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;


	public Long getTemasCursoId() {
		return temasCursoId;
	}

	public void setTemasCursoId(Long temasCursoId) {
		this.temasCursoId = temasCursoId;
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

	public BigDecimal getTemaOrden() {
		return temaOrden;
	}

	public void setTemaOrden(BigDecimal temaOrden) {
		this.temaOrden = temaOrden;
	}

	public ActiveInactiveStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ActiveInactiveStatusEnum status) {
		this.status = status;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((temasCursoId == null) ? 0 : temasCursoId.hashCode());
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
		TemasCurso other = (TemasCurso) obj;
		if (temasCursoId == null) {
			if (other.temasCursoId != null)
				return false;
		} else if (!temasCursoId.equals(other.temasCursoId))
			return false;
		return true;
	}



}
