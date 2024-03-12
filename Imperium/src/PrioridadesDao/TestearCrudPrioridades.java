package PrioridadesDao;

import java.util.List;

import Models.ClasePrioridades;

public class TestearCrudPrioridades {

	public static void main(String[] args) {
		// llamamos a las clases
		ClasePrioridades clpri = new ClasePrioridades();
		CrudPrioridades crud = new CrudPrioridades();

		// mandamos los valores
		 clpri.setId(2);
		clpri.setNombre_prioridad("BAJO");

		// ejecutamos el registrar
		//crud.registrar(clpri);
		// ejecutamos el actualziar
		crud.actualizar(clpri);
		// ejecutamos el eliminar
		// crud.eliminar(clpri);

		// tsteamos el listarprioridades

		//List<ClasePrioridades> listarprioridades = crud.ListarPrioridades();
		/*
		 * for(ClasePrioridades listado :listarprioridades){ System.out.println(
		 * "ID : "+ listado.getId() + "\n " + "NOMBRE DE PRIORIDAD : " +
		 * listado.getNombre_prioridad() + "\n " + "ESTADO : " +
		 * listado.getEstado()); }
		 */

		/*
		 * 
		 * listarprioridades.forEach((listado) -> { System.out.println("ID : "+
		 * listado.getId() + "\n " + "NOMBRE DE PRIORIDAD : " +
		 * listado.getNombre_prioridad());
		 * 
		 * });
		 */

		/*
		 * for(int x=0; x < listarprioridades.size(); x++){ ClasePrioridades
		 * listado = listarprioridades.get(x); System.out.println("ID : "+
		 * listado.getId() ); }
		 */

		// testeamos el buscar
		/*
		 * ClasePrioridades buscarprioridadporcodigo =
		 * crud.buscarprioridades(clpri); System.out.println("ID : " +
		 * buscarprioridadporcodigo.getId() + "\n " + "NOMBRE : " +
		 * buscarprioridadporcodigo.getNombre_prioridad());
		 */
	}

}
