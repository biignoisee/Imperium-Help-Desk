package Interfaces;

import java.util.List;
import Models.Categoria;

public interface IntCategoriaAble {
	void RegistrarCategoria(Categoria clcat);

	void ActualizarCategoria(Categoria clcat);

	void EliminarCategoria(Categoria clcat);

	List<Categoria> ListarCategoria();

	Categoria BuscarCategoria(Categoria buscat);
}
