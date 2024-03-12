package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CategoriaDao.CrudCategoriaImp;
import Models.Categoria;

@WebServlet("/ControladorCategoria")
public class ControladorCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String accion = request.getParameter("accion");

		if (accion != null) {
			// aplicamos una condición
			// aplicamos un switch
			switch (accion) {
			case "listar":
				CrudCategoriaImp crudCat = new CrudCategoriaImp();
				List<Categoria> listarcategorias = crudCat.ListarCategoria();
				request.setAttribute("listarcategorias", listarcategorias);
				request.getRequestDispatcher("/ListadoCategoria.jsp").forward(request, response);
				break;
			case "actualizar":
				// declaramos una variable de tipo string de nombre url
				String url = "/formActualizarCategoria.jsp";

				// instanciamos las respectivas clases
				Categoria clcat = new Categoria();
				CrudCategoriaImp crudcat = new CrudCategoriaImp();

				// recuperamos el codigo - codigo porque en el listado lo
				// agregamos la ruta ahref
				int id = Integer.parseInt(request.getParameter("codigo"));

				// asignamos el codigo
				clcat.setId(id);

				// realizo una busqueda mediante dicho codigo
				Categoria buscat = crudcat.BuscarCategoria(clcat);

				// asignamos los valores recuperados de la base de daots para
				// enviarlos a la vista
				request.setAttribute("id", buscat.getId());
				request.setAttribute("nombre", buscat.getNombre());
				request.setAttribute("estado", buscat.getEstado());

				// redireccionamos
				request.getRequestDispatcher(url).forward(request, response);

				break;

			case "eliminar":
				break;
			}

		} // fin de la condición

	} // fin del metodo doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperar datos del formulario
		// declaramos las respectivas variables
		String nombre = request.getParameter("nombre");
		int estado = Integer.parseInt(request.getParameter("estado"));

		// instanciar las respectivas clases...
		Categoria clascat = new Categoria();
		CrudCategoriaImp crudcat = new CrudCategoriaImp();
		// asignamos los valores
		clascat.setNombre(nombre);
		clascat.setEstado(estado);

		crudcat.RegistrarCategoria(clascat);

		// Actualizamos la categoria...
		List<Categoria> listarcategorias = crudcat.ListarCategoria();

		// enviamos los datos a la vista y
		request.setAttribute("listarcategorias", listarcategorias);

		// redireccionamos el listado de categorias
		// declaramos una variable de tipo string
		String url = "/ListadoCategoria.jsp";

		request.getRequestDispatcher(url).forward(request, response);

		// doGet(request, response);
	} // fin del metodo doPost

}
