package pe.joedayz.api.domain.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;

@Entity
@Table(name = "datos_curso")
public class DatosCurso extends AuditingEntity implements Serializable, BaseEntity{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "datos_curso_id")
	private Long datosCursoId;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    public Curso curso;

	
	
	@Column(name = "descripcion_curso", nullable=true, length=1000)
	private String descripcionCurso;

	@Column(name = "temas_curso", nullable=true, length=2000)
	private String temasCurso;	
	
	@Column(name = "requisitos_curso", nullable=true, length=600)
	private String preRequisitosCurso;
	
	@Column(name = "participantes_curso", nullable=true, length=20)
	private String participantesCurso;	

	@Column(name = "metodologia_curso", nullable=true, length=100)
	private String metodologiaCurso;	
	
	@Column(name = "syllabus_curso", nullable=true, length=200)
	private String syllabusCurso;		
		
	
	@Column(name = "instructor_curso", nullable=true, length=200)
	private String instructorCurso;		


	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getDescripcionCurso() {
		return descripcionCurso;
	}

	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}

	public String getTemasCurso() {
		return temasCurso;
	}

	public void setTemasCurso(String temasCurso) {
		this.temasCurso = temasCurso;
	}

	public String getPreRequisitosCurso() {
		return preRequisitosCurso;
	}

	public void setPreRequisitosCurso(String preRequisitosCurso) {
		this.preRequisitosCurso = preRequisitosCurso;
	}

	public String getParticipantesCurso() {
		return participantesCurso;
	}

	public void setParticipantesCurso(String participantesCurso) {
		this.participantesCurso = participantesCurso;
	}

	public String getMetodologiaCurso() {
		return metodologiaCurso;
	}

	public void setMetodologiaCurso(String metodologiaCurso) {
		this.metodologiaCurso = metodologiaCurso;
	}

	public String getSyllabusCurso() {
		return syllabusCurso;
	}

	public void setSyllabusCurso(String syllabusCurso) {
		this.syllabusCurso = syllabusCurso;
	}


	public String getInstructorCurso() {
		return instructorCurso;
	}

	public void setInstructorCurso(String instructorCurso) {
		this.instructorCurso = instructorCurso;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datosCursoId == null) ? 0 : datosCursoId.hashCode());
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
		DatosCurso other = (DatosCurso) obj;
		if (datosCursoId == null) {
			if (other.datosCursoId != null)
				return false;
		} else if (!datosCursoId.equals(other.datosCursoId))
			return false;
		return true;
	}



}
