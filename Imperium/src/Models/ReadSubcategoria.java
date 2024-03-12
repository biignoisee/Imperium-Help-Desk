package Models;

public class ReadSubcategoria {
	private int id;
	private String nombre;
	
	public ReadSubcategoria() {
		
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

	@Override
	public String toString() {
		return "ReadSubcategoriaDto [id=" + id + ", nombre=" + nombre + ", getId()=" + getId() + ", getNombre()="
				+ getNombre() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
