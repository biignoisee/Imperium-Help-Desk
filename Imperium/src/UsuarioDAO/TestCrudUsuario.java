package UsuarioDAO;

import java.util.List;

import Models.ClassUsuario;

public class TestCrudUsuario {

	public static void main(String[] args) {
		// instanciar las respectivas clases...
		ClassUsuario cusu = new ClassUsuario();
		CrudUsuarioImp crud = new CrudUsuarioImp();
				
		//asignamos los respectivos valores...
		/* cusu.setRole_id(2);
		cusu.setNombre("Cristopher");
		cusu.setApellido_paterno("Coronel");
		cusu.setApellido_materno("Zavaleta");
		cusu.setDni("11111111");
		cusu.setUsername("ADMI");
		cusu.setPassword("123456");*/
		// cusu.setId(1); 
		
		
		// REGISTAR USUARIO - C
		// crud.RegistrarUsuario(cusu);
		
		// LISTAR USUARIOS - R
		List<ClassUsuario> listarusuarios = crud.ListarUsuario();
		for(ClassUsuario listado : listarusuarios){
			System.out.println("Nombre usuario: " + listado.getNombre() + ", " + "DNI: " + listado.getDni() + ", " + "Estado: " + listado.getEstado() + "\n");
		}
		
		// ACTUALIZAR DATOS DE USUARIO - U
		// crud.ActualizarUsuario(cusu);
		
		// ELIMINAR LÓGICAMENTE USUARIO - D
		//crud.EliminarUsuario(cusu);
		
		
		// BUSCAR USUARIO
		/* ClassUsuario buscarporcod = crud.BuscarUsuario(cusu);
		System.out.println("Código:" + buscarporcod.getId() + " - Nombre: " + buscarporcod.getNombre()); */
		
	}

}
