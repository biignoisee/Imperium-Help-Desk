package Interfaces;

import java.util.List;

import Models.ClasePrioridades;

public interface IntPrioridable {
	//creamos los respectivos metodos
	void registrar(ClasePrioridades claspri);
	void actualizar (ClasePrioridades claspri);
	void eliminar (ClasePrioridades claspri);
	List<ClasePrioridades> ListarPrioridades();
	ClasePrioridades buscarprioridades(ClasePrioridades buscpri);

}
