package Models;

public class ReadUsuarioSoporte {
	private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apelidoMaterno;
	private String dni;
	private int cantidadIncidencias;
	
	public ReadUsuarioSoporte() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApelidoMaterno() {
		return apelidoMaterno;
	}

	public void setApelidoMaterno(String apelidoMaterno) {
		this.apelidoMaterno = apelidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCantidadIncidencias() {
		return cantidadIncidencias;
	}

	public void setCantidadIncidencias(int cantidadIncidencias) {
		this.cantidadIncidencias = cantidadIncidencias;
	}
}
