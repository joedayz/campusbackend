package pe.joedayz.api.dto;

import java.math.BigDecimal;

public class TemasCursoDto {

	private Long temasCursoId;
	private String titulo;
	private String descripcion;
	private String url;
	private BigDecimal temaOrden;
	private String status;
	private Long cursoId;

	
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCursoId() {
		return cursoId;
	}
	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

	
	
	
}
