package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SubCategoria;
import SubCategoriaDao.CrudSubCategoriaImp;

/**
 * Servlet implementation class ControladorSubCategoria
 */
@WebServlet("/ControladorSubCategoria")
public class ControladorSubCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorSubCategoria() {
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

		// aplicamos una condición
		if (accion != null) {
			// aplicamos un switch
			switch (accion) {
			case "listar":
				CrudSubCategoriaImp crudsbCat = new CrudSubCategoriaImp();
				List<SubCategoria> listarsubcategorias = crudsbCat.ListarSubCategoria();
				request.setAttribute("listarsubcategorias", listarsubcategorias);
				request.getRequestDispatcher("/ListadoSubCategoria.jsp").forward(request, response);
				break;
			case "actualizar":
				// declaramos una variable de tipo string de nombre url
				String url = "/formActualizarSubCategoria.jsp";

				// instanciamos las respectivas clases
				SubCategoria clsbcat = new SubCategoria();
				CrudSubCategoriaImp crudsbcat = new CrudSubCategoriaImp();

				// recuperamos el codigo - codigo porque en el listado lo
				// agregamos la ruta ahref
				int id = Integer.parseInt(request.getParameter("codigo"));

				// asignamos el codigo
				clsbcat.setId(id);

				// realizo una busqueda mediante dicho codigo
				SubCategoria bussbcat = crudsbcat.BuscarSubCategoria(clsbcat);

				// asignamos los valores recuperados de la base de daots para
				// enviarlos a la vista
				request.setAttribute("id", bussbcat.getId());
				request.setAttribute("categoria_id", bussbcat.getCategoria_id());
				request.setAttribute("nombre", bussbcat.getNombre());
				request.setAttribute("estado", bussbcat.getEstado());

				// redireccionamos
				request.getRequestDispatcher(url).forward(request, response);

				break;

			case "eliminar":
				break;
			}

		} // fin de la condición

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recuperar datos del formulario
		// declaramos las respectivas variables
		int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
		String nombre = request.getParameter("nombre");
		int estado = Integer.parseInt(request.getParameter("estado"));

		// instanciar las respectivas clases...
		SubCategoria clasSubCat = new SubCategoria();
		CrudSubCategoriaImp crudCat = new CrudSubCategoriaImp();
		// asignamos los valores
		clasSubCat.setCategoria_id(categoria_id);
		clasSubCat.setNombre(nombre);
		clasSubCat.setEstado(estado);

		crudCat.RegistrarSubCategoria(clasSubCat);

		// Actualizamos la categoria...
		List<SubCategoria> listarsubcategorias = crudCat.ListarSubCategoria();

		// enviamos los datos a la vista y
		request.setAttribute("listarsubcategorias", listarsubcategorias);

		// redireccionamos el listado de categorias
		// declaramos una variable de tipo string
		String url = "/ListadoSubCategoria.jsp";

		request.getRequestDispatcher(url).forward(request, response);

		// doGet(request, response);
	}

}
