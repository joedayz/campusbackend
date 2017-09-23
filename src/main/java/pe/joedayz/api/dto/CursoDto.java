package pe.joedayz.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CursoDto {

	private Long cursoId;
    private Long tipoCursoId;
    private String tituloCurso;
    private String tituloFooterCurso;
    private String status;
    private String destacadoHome;
    private String keyCurso;
    
    //DatosCurso
	private String descripcionCurso;
	private String temasCurso;
	private String preRequisitosCurso;
	private String participantesCurso;	
	private String metodologiaCurso;	
	private String syllabusCurso;	
	
	private String instructorCurso;
    //DetallesCurso
	private String duracionCurso;	
	private String horariosCurso;	
	private String fechaInscripcionCurso;
	private String numeroParticipantes;	
	private BigDecimal costo;
	private BigDecimal membresiaAnual;    
    
    private List<TemasCursoDto> temasList = new ArrayList<>();
    
    
	public Long getCursoId() {
		return cursoId;
	}
	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
	public Long getTipoCursoId() {
		return tipoCursoId;
	}
	public void setTipoCursoId(Long tipoCursoId) {
		this.tipoCursoId = tipoCursoId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDestacadoHome() {
		return destacadoHome;
	}
	public void setDestacadoHome(String destacadoHome) {
		this.destacadoHome = destacadoHome;
	}
	public List<TemasCursoDto> getTemasList() {
		return temasList;
	}
	public void setTemasList(List<TemasCursoDto> temasList) {
		this.temasList = temasList;
	}
	public String getKeyCurso() {
		return keyCurso;
	}
	public void setKeyCurso(String keyCurso) {
		this.keyCurso = keyCurso;
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
