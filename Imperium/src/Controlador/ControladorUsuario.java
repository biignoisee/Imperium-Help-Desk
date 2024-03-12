package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ClassUsuario;
import UsuarioDAO.CrudUsuarioImp;

/**
 * Servlet implementation class ControladorUsuario
 */
@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassUsuario classusuario = new ClassUsuario();
		CrudUsuarioImp crudusuario = new CrudUsuarioImp();
		List<ClassUsuario> listar = crudusuario.ListarUsuario();
		
		String accion = request.getParameter("accion");
		if(accion != null){
			switch (accion) {
			
			case "eliminar":
				int id = Integer.parseInt(request.getParameter("id"));
				
				classusuario.setId(id);
				crudusuario.EliminarUsuario(classusuario);
				
				listar = crudusuario.ListarUsuario();
				request.setAttribute("listadousuarios", listar);
				String url = "ListarUsuario.jsp";
				request.getRequestDispatcher(url).forward(request, response);
				
				break;
				
			case "actualizar":
				int id2 = Integer.parseInt(request.getParameter("id"));
				classusuario.setId(id2);
				ClassUsuario buscarUsuario = crudusuario.BuscarUsuario(classusuario);
				
				request.setAttribute("id", id2);
				request.setAttribute("nombre", buscarUsuario.getNombre());
				request.setAttribute("apellido_paterno", buscarUsuario.getApellido_paterno());
				request.setAttribute("apellido_materno", buscarUsuario.getApellido_materno());
				request.setAttribute("dni", buscarUsuario.getDni());
				request.setAttribute("username", buscarUsuario.getUsername());
				request.setAttribute("password", buscarUsuario.getPassword());
				request.setAttribute("role_id", buscarUsuario.getRole_id());
				
				request.getRequestDispatcher("ActualizarUsuario.jsp").forward(request, response);
				break;
			
			case "listar":
				request.setAttribute("listadousuarios", listar);
				String url2 = "ListarUsuario.jsp";
				request.getRequestDispatcher(url2).forward(request, response);
				break;
				
			case "Actualizar":
				int idUsuario = Integer.parseInt(request.getParameter("id"));
				String nombreUsuario = request.getParameter("nombre");
				String apellido_paternoUsuario = request.getParameter("apellido_paterno");
				String apellido_maternoUsuario = request.getParameter("apellido_materno");
				String dniUsuario = request.getParameter("dni");
				String usernameUsuario = request.getParameter("username");
				String passwordUsuario = request.getParameter("password");
				int role_idUsuario = Integer.parseInt(request.getParameter("role_id"));
				
				ClassUsuario classUsu = new ClassUsuario();
				classUsu.setId(idUsuario);
				classUsu.setNombre(nombreUsuario);
				classUsu.setApellido_paterno(apellido_paternoUsuario);
				classUsu.setApellido_materno(apellido_maternoUsuario);
				classUsu.setDni(dniUsuario);
				classUsu.setUsername(usernameUsuario);
				classUsu.setPassword(passwordUsuario);
				classUsu.setRole_id(role_idUsuario);
				
				crudusuario.ActualizarUsuario(classUsu);
				
				listar = crudusuario.ListarUsuario();
				request.setAttribute("listadousuarios", listar);
				String url3 = "ListarUsuario.jsp";
				request.getRequestDispatcher(url3).forward(request, response);
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
		ClassUsuario classusuario = new ClassUsuario();
		CrudUsuarioImp crudusuario = new CrudUsuarioImp();
		
		String nombre = request.getParameter("nombre");
		String apellido_paterno = request.getParameter("apellido_paterno");
		String apellido_materno = request.getParameter("apellido_materno");
		String dni = request.getParameter("dni");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int role_id = Integer.parseInt(request.getParameter("role_id"));
			
		classusuario.setNombre(nombre);
		classusuario.setApellido_paterno(apellido_paterno);
		classusuario.setApellido_materno(apellido_materno);
		classusuario.setDni(dni);
		classusuario.setUsername(username);
		classusuario.setPassword(password);
		classusuario.setRole_id(role_id);
		
		if(nombre != null && apellido_paterno != null && apellido_materno != null && dni != null && username != null && password != null && role_id != 0){
			crudusuario.RegistrarUsuario(classusuario);
			System.out.println("Nombre: " + nombre);
			System.out.println("Username: " + username);
		} else{
			System.out.println("ERROR");
		}
			
		List<ClassUsuario> listar = crudusuario.ListarUsuario();
		request.setAttribute("listadousuarios", listar);
		String url = "ListarUsuario.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
