package Models;

import java.util.Date;

public class CreateIncidencia {
	private String titulo;
	private int subcategoriaId;
	private int prioridadId;
	private String descripcion;
	private int usuarioId;
	private Date fechaCreacion;
	
	public CreateIncidencia() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getSubcategoriaId() {
		return subcategoriaId;
	}

	public void setSubcategoriaId(int subcategoriaId) {
		this.subcategoriaId = subcategoriaId;
	}

	public int getPrioridadId() {
		return prioridadId;
	}

	public void setPrioridadId(int prioridadId) {
		this.prioridadId = prioridadId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
