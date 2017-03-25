package pe.joedayz.api.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import pe.joedayz.api.json.JsonDateSimpleDeserializer;

public class ArticuloDto {

	private Long articuloId;
    private String titulo;
    private String url;
    private String descripcion;
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date fecha;
    private String status;
    private String autor;
	public Long getArticuloId() {
		return articuloId;
	}
	public void setArticuloId(Long articuloId) {
		this.articuloId = articuloId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
    
    
    
}
