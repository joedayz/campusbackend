package pe.joedayz.api.dto;

import java.math.BigDecimal;

public class DetallesCursoDto {

	private Long detallesCursoId;
	private Long cursoId;
	private String duracionCurso;	
	private String horariosCurso;	
	private String fechaInscripcionCurso;
	private String numeroParticipantes;	
	private BigDecimal costo;
	private BigDecimal membresiaAnual;
	
	public Long getDetallesCursoId() {
		return detallesCursoId;
	}
	public void setDetallesCursoId(Long detallesCursoId) {
		this.detallesCursoId = detallesCursoId;
	}
	public Long getCursoId() {
		return cursoId;
	}
	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
	public String getDuracionCurso() {
		return duracionCurso;
	}
	public void setDuracionCurso(String duracionCurso) {
		this.duracionCurso = duracionCurso;
	}
	public String getHorariosCurso() {
		return horariosCurso;
	}
	public void setHorariosCurso(String horariosCurso) {
		this.horariosCurso = horariosCurso;
	}
	public String getFechaInscripcionCurso() {
		return fechaInscripcionCurso;
	}
	public void setFechaInscripcionCurso(String fechaInscripcionCurso) {
		this.fechaInscripcionCurso = fechaInscripcionCurso;
	}
	public String getNumeroParticipantes() {
		return numeroParticipantes;
	}
	public void setNumeroParticipantes(String numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public BigDecimal getMembresiaAnual() {
		return membresiaAnual;
	}
	public void setMembresiaAnual(BigDecimal membresiaAnual) {
		this.membresiaAnual = membresiaAnual;
	}
	
	
}
