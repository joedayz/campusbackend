package pe.joedayz.api.dto;

public class TipoCursoDto {

	
	private Long tipoCursoId;
	
	private String nombre;
	
	private String status;

	public Long getTipoCursoId() {
		return tipoCursoId;
	}

	public void setTipoCursoId(Long tipoCursoId) {
		this.tipoCursoId = tipoCursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
