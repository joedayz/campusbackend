package pe.joedayz.api.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import pe.joedayz.api.json.JsonDateSimpleDeserializer;

public class HangoutDto {

	
	private Long hangoutId;
    private String titulo;
    private String url;
    private String descripcion;
    @JsonDeserialize(using=JsonDateSimpleDeserializer.class)
    private Date fecha;
    private String status;
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
	public String getPonente() {
		return ponente;
	}
	public void setPonente(String ponente) {
		this.ponente = ponente;
	}
    
    
}
