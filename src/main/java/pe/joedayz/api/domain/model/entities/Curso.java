package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;
import pe.joedayz.api.enums.YesNoEnum;

@Entity
@Table(name = "curso")
@NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
public class Curso extends AuditingEntity implements Serializable, BaseEntity{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private Long cursoId;

    @ManyToOne
    @JoinColumn(name = "tipo_curso", nullable = false)
    public TipoCurso tipoCurso;
    
	@Column(name = "key_curso", nullable=false, length=100,  unique=true)
	private String keyCurso;
    
    
	@Column(name = "titulo_curso", nullable=false, length=200)
	private String tituloCurso;

	
	@Column(name = "titulo_footer_curso", nullable=false, length=100)
	private String tituloFooterCurso;

    	
	@Column(name = "status")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType", parameters = {
			@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.ActiveInactiveStatusEnum") })
	private ActiveInactiveStatusEnum status;
	
	
	@Column(name = "destacado_home")
	@Type(type = "pe.joedayz.api.enums.GenericEnumUserType", parameters = {
			@org.hibernate.annotations.Parameter(name = "enumClass", value = "pe.joedayz.api.enums.YesNoEnum") })
	private YesNoEnum destacadoHome;

	
	
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    
	private List<TemasCurso> temas;
	

	public List<TemasCurso> getTemas() {
		return temas;
	}

	public void setTemas(List<TemasCurso> temas) {
		this.temas = temas;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public String getTituloCurso() {
		return tituloCurso;
	}

	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
	}

	public String getTituloFooterCurso() {
		return tituloFooterCurso;
	}

	public void setTituloFooterCurso(String tituloFooterCurso) {
		this.tituloFooterCurso = tituloFooterCurso;
	}

	public ActiveInactiveStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ActiveInactiveStatusEnum status) {
		this.status = status;
	}

	public YesNoEnum getDestacadoHome() {
		return destacadoHome;
	}

	public void setDestacadoHome(YesNoEnum destacadoHome) {
		this.destacadoHome = destacadoHome;
	}
	
	
	

	public String getKeyCurso() {
		return keyCurso;
	}

	public void setKeyCurso(String keyCurso) {
		this.keyCurso = keyCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursoId == null) ? 0 : cursoId.hashCode());
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
		Curso other = (Curso) obj;
		if (cursoId == null) {
			if (other.cursoId != null)
				return false;
		} else if (!cursoId.equals(other.cursoId))
			return false;
		return true;
	}


	
	
	
}
