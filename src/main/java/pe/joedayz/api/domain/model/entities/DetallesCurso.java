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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.joedayz.api.domain.model.base.AuditingEntity;
import pe.joedayz.api.domain.model.base.BaseEntity;

@Entity
@Table(name = "detalles_curso")
public class DetallesCurso extends AuditingEntity implements Serializable, BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detalles_curso_id")
	private Long detallesCursoId;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    public Curso curso;

    
    
	@Column(name = "duracion_curso", nullable=true, length=200)
	private String duracionCurso;	
	
	@Column(name = "horarios_curso", nullable=true, length=200)
	private String horariosCurso;	
	
	@Column(name = "fecha_inscripcion_curso", nullable=true, length=200)
	private String fechaInscripcionCurso;	
	
	@Column(name = "numero_participantes", nullable=true, length=200)
	private String numeroParticipantes;	
	
    @Column(name = "costo")
    private BigDecimal costo;
    
	
    @Column(name = "membresiaAnual")
    private BigDecimal membresiaAnual;
    


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detallesCursoId == null) ? 0 : detallesCursoId.hashCode());
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
		DetallesCurso other = (DetallesCurso) obj;
		if (detallesCursoId == null) {
			if (other.detallesCursoId != null)
				return false;
		} else if (!detallesCursoId.equals(other.detallesCursoId))
			return false;
		return true;
	}


}
