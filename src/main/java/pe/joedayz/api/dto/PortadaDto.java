package pe.joedayz.api.dto;

public class PortadaDto {

	private Long portadaId;
	private String tituloFoto;
	private String descripcionFoto;
	private String urlFoto;
	private String status;
	
	public Long getPortadaId() {
		return portadaId;
	}
	public void setPortadaId(Long portadaId) {
		this.portadaId = portadaId;
	}
	public String getTituloFoto() {
		return tituloFoto;
	}
	public void setTituloFoto(String tituloFoto) {
		this.tituloFoto = tituloFoto;
	}
	public String getDescripcionFoto() {
		return descripcionFoto;
	}
	public void setDescripcionFoto(String descripcionFoto) {
		this.descripcionFoto = descripcionFoto;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
