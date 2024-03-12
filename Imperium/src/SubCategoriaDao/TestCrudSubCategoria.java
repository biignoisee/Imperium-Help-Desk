package SubCategoriaDao;

import Models.SubCategoria;

public class TestCrudSubCategoria {
	public static void main(String[] args) {
		// instanciar las respectivas clases...
		SubCategoria sbcat = new SubCategoria();
		CrudSubCategoriaImp crud = new CrudSubCategoriaImp();

		/*
		 * REGISTRAMOS PRIMERO
		 * 
		 * //EMPEZAMOS CON HARDWARE sbcat.setNombre("Impresoras");
		 * sbcat.setCategoria_id(1); sbcat.setEstado(1);
		 * 
		 * sbcat.setNombre("Mouse"); sbcat.setCategoria_id(1);
		 * sbcat.setEstado(1);
		 * 
		 * sbcat.setNombre("Caja Refrigeradora"); sbcat.setCategoria_id(1);
		 * sbcat.setEstado(1);
		 * 
		 * sbcat.setNombre("Faja Traansportadora"); sbcat.setCategoria_id(1);
		 * sbcat.setEstado(1);
		 * 
		 * //Registrar Categoria crud.RegistrarSubCategoria(sbcat);
		 * 
		 * 
		 * AHI YA SE REGISTRA LO QUE FALTA PS, PERO SI ESTA REGISTRANDO TODOOOO
		 */

		// ----------------------------------------------------------------------------------

		/* Listar SUBcategoria */

		// ATENCION!!!!!!!!!!!!!!! Solo me lista el ultimo registro
		/*
		 * List<SubCategoria> listarsubcategorias = crud.ListarSubCategoria();
		 * for(SubCategoria listado : listarsubcategorias){ System.out.println(
		 * " - Id SubCategoria: " +listado.getId() +
		 * "\n - Nombre SubCategoria: "+ listado.getCategoria_id() +
		 * "\n - Nombre SubCategoria: " + listado.getNombre() + "\n"); }
		 */

		// -------------------------------------------------------------------------------------------

		// Actualizar datos de categoria
		// funciona perfectamente

		/*
		 * sbcat.setCategoria_id(1); sbcat.setNombre("Impresoras");
		 * sbcat.setEstado(0); sbcat.setId(1);
		 * 
		 * crud.ActualizarSubCategoria(sbcat);
		 * 
		 */

		// ------------------------------------------------------------------------------------

		// ELIMINAR SubCategoria FUNCIONA RE GOD

		/*
		 * //registro uno para el ejemplo sbcat.setCategoria_id(2);
		 * sbcat.setNombre("Mierda xd"); sbcat.setEstado(1);
		 * 
		 * //Registrar SubCategoria crud.RegistrarSubCategoria(sbcat);
		 * 
		 * 
		 * //Eliminar categoria sbcat.setId(5);
		 * crud.EliminarSubCategoria(sbcat);
		 * 
		 */

		// ---------------------------------------------------------------------------------------

		// BUSCAR SubCATEGORIA
		sbcat.setId(6);

		SubCategoria buscarporcod = crud.BuscarSubCategoria(sbcat);
		System.out.println(
				"Código SubCategoria:" + buscarporcod.getId() + " \n - ID Categoria: " + buscarporcod.getCategoria_id()
						+ " \n - Nombre: " + buscarporcod.getNombre() + " \n - Estado: " + buscarporcod.getEstado());

	}
}
