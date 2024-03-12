package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ClasePrioridades;
import PrioridadesDao.CrudPrioridades;

/**
 * Servlet implementation class ControladorPrioridades
 */
@WebServlet("/ControladorPrioridades")
public class ControladorPrioridades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPrioridades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClasePrioridades claspri = new ClasePrioridades();
		CrudPrioridades crud = new CrudPrioridades();
		List<ClasePrioridades> listar = crud.ListarPrioridades();
		
		String accion = request.getParameter("accion");
		if(accion != null){
			switch (accion) {
			case "eliminar":
				int codigo = Integer.parseInt(request.getParameter("codigo"));
				
				claspri.setId(codigo);
				crud.eliminar(claspri);
				
				listar = crud.ListarPrioridades();
				request.setAttribute("listado", listar);
				String url="ListarPrioridades.jsp";
				request.getRequestDispatcher(url).forward(request, response);
				
				break;
			case "actualizar":
				int codigo2 = Integer.parseInt(request.getParameter("codigo"));
				claspri.setId(codigo2);
				ClasePrioridades buscpri = crud.buscarprioridades(claspri);
				
				request.setAttribute("id", codigo2);
				request.setAttribute("nombre_prioridad", buscpri.getNombre_prioridad());
			
				request.getRequestDispatcher("ActualizarPrioridades.jsp").forward(request, response);
				break;
			case "actualizar-prioridad":
				int codigoId = Integer.parseInt(request.getParameter("id"));
				String nombrePrioridad = request.getParameter("nombre_prioridad");
				
				ClasePrioridades classPri = new ClasePrioridades();
				classPri.setId(codigoId);
				classPri.setNombre_prioridad(nombrePrioridad);
				
				crud.actualizar(classPri);
				
				listar = crud.ListarPrioridades();
				request.setAttribute("listado", listar);
				String url3 = "ListarPrioridades.jsp";
				request.getRequestDispatcher(url3).forward(request, response);
				break;
			case "listar":
				request.setAttribute("listado", listar);
				String url2 = "ListarPrioridades.jsp";
				request.getRequestDispatcher(url2).forward(request, response);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClasePrioridades clprio = new ClasePrioridades();
		CrudPrioridades crud = new CrudPrioridades();
		String nom = request.getParameter("nombre");
			
		clprio.setNombre_prioridad(nom);
		if(nom != null){
			crud.registrar(clprio);
			System.out.println("NOMBRE : " + nom);
		} else{
			System.out.println("ERROR");
		}
			
		List<ClasePrioridades> listar = crud.ListarPrioridades();
		request.setAttribute("listado", listar);
		String url = "ListarPrioridades.jsp";
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
