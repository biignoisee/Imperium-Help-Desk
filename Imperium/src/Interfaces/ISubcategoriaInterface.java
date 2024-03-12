package Interfaces;

import java.util.List;
import Models.ReadSubcategoria;

public interface ISubcategoriaInterface {
	public List<ReadSubcategoria> getSubcategoriasByCategoria(int categoriaId);
}
