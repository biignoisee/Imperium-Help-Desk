package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.ClassUsuario;
import UsuarioDAO.CrudUsuarioImp;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		ClassUsuario usuariologin = new ClassUsuario();
		usuariologin.setUsername(usuario);
		usuariologin.setPassword(password);
		
		CrudUsuarioImp validarusuario = new CrudUsuarioImp();
		ClassUsuario validarlogin = validarusuario.loginUsuario(usuariologin);
		
		
		if(validarlogin.getUsername() != null && validarlogin.getPassword() != null){
			 url = "/Lobby.jsp";
		 }else{
			 url = "/Login.jsp";
		 }
		request.getRequestDispatcher(url).forward(request, response);
	}

}
