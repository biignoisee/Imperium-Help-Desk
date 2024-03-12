package CategoriaDao;

import Models.Categoria;

public class TestCrudCategoria {
	public static void main(String [] args){
		// instanciar las respectivas clases...
		Categoria ccat = new Categoria();
		CrudCategoriaImp crud = new CrudCategoriaImp();
		
		/*REGISTRAMOS PRIMERO
		 
		 ccat.setNombre("Hardware");
		 ccat.setEstado(1);
		
		 ccat.setNombre("Software");
		 ccat.setEstado(1);
		 
		 ccat.setNombre("Server");
		 ccat.setEstado(1);
		
		//Registrar Categoria
		crud.RegistrarCategoria(ccat);
		 
		 */
		
		
		
		// ----------------------------------------------------------------------------------
		
		
		
		/*Listar categoria*/
		
		//ATENCION!!!!!!!!!!!!!!! Solo me lista el ultimo registro 
		
		 
		/*
		List<Categoria> listado_categoria = crud.ListarCategoria();
		for(Categoria listado:listado_categoria){
			System.out.println("Id Categoria: " + listado.getId() +  "\n" +
					"Nombre Categoria: " + listado.getNombre() +  "\n" + "Estado: " + listado.getEstado() + "\n" );
		} 
		
		*/
		
		
		
		
		
		
		
		
		
		// -------------------------------------------------------------------------------------------
		
		/*
		
		// Actualizar datos de categoria
		//funciona perfectamente
		
		
		 ccat.setNombre("Server");
		 ccat.setEstado(0);
		 ccat.setId(3);
		 
		crud.ActualizarCategoria(ccat);			
		
		*/
		
		
		// ------------------------------------------------------------------------------------
		
		// ELIMINAR  Categoria    FUNCIONA RE GOD
		
		/*//registro uno para el ejemplo
		 ccat.setNombre("apache");
		 ccat.setEstado(1);
		
		//Registrar Categoria
		crud.RegistrarCategoria(ccat);*/
		
		//ccat.setId(4);
		//crud.EliminarCategoria(ccat);
		
		// ---------------------------------------------------------------------------------------
		
		
		 //BUSCAR CATEGORIA
		ccat.setId(1);
		Categoria buscarporcod = crud.BuscarCategoria(ccat);
		
		//imprimimos por pantalla el producto buscado por codigo
		System.out.println(" - Código: " + buscarporcod.getId() + " \n - Nombre: " + buscarporcod.getNombre() + 
				" \n - Estado: " + buscarporcod.getEstado());
		
		
	}	
}
