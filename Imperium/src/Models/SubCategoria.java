package Models;

public class SubCategoria {
	private int id;
	private int categoria_id; // referencia a id de Categoria
	private String nombre;
	private int estado;

	public SubCategoria() {

	}

	public SubCategoria(int id, int categoria_id, String nombre, int estado) {
		super();
		this.id = id;
		this.categoria_id = categoria_id;
		this.nombre = nombre;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
