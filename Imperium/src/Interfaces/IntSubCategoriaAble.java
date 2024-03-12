package Interfaces;

import java.util.List;
import Models.SubCategoria;

public interface IntSubCategoriaAble {
	void RegistrarSubCategoria(SubCategoria clsbcat);

	void ActualizarSubCategoria(SubCategoria clsbcat);

	void EliminarSubCategoria(SubCategoria clsbcat);

	List<SubCategoria> ListarSubCategoria();

	SubCategoria BuscarSubCategoria(SubCategoria bussbcat);
}
