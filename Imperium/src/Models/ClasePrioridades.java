package Models;

public class ClasePrioridades {
	// declaramos los atributos
	private int id;
	private String nombre_prioridad;
	private int estado;

	public ClasePrioridades(int id, String nombre_prioridad, int estado) {
		// super();
		this.id = id;
		this.nombre_prioridad = nombre_prioridad;
		this.estado = estado;
	}

	public ClasePrioridades() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_prioridad() {
		return nombre_prioridad;
	}

	public void setNombre_prioridad(String nombre_prioridad) {
		this.nombre_prioridad = nombre_prioridad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	// metodos set y get

}
