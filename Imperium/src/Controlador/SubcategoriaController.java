package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Models.ReadSubcategoria;
import SubCategoriaDao.SubcategoriaMantenimiento;

/**
 * Servlet implementation class SubcategoriaController
 */
@WebServlet(name = "subcategorias", urlPatterns = {"/subcategorias"})
public class SubcategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategoriaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch (accion) {
		case "r": readSubcategorias(request, response); break;
		default:
			break;
		}
	}
	
	private void readSubcategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));
		
		SubcategoriaMantenimiento sm = new SubcategoriaMantenimiento();
		List<ReadSubcategoria> subcategorias = sm.getSubcategoriasByCategoria(categoriaId);
		response.setContentType("application/json");
		String json = new Gson().toJson(subcategorias);
		response.getWriter().write(json);
	}

}
