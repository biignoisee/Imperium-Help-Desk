package ConectarBD_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarMYSQL {
	
	//declaramos variables globales
		private static String url="jdbc:mysql://localhost:3306/BD_IMPERIUM_HELPDESK";
		private static String usuario="root";
		private static String password="";
		private static Connection con;
		
		//creamos un metodo de conexion
		public static Connection getConnection(){
			

			try {
				Class.forName("com.mysql.jdbc.Driver");
				//nos conectamos con la base de datos MYSQL(BDLPIIEJEMPLO)
				con=DriverManager.getConnection(url,usuario,password);
				//aplicamos una condicion if
				/*if(con!=null)  JOptionPane.showMessageDialog(null,"conexion con base de datos EXISTOSA!!!",
						"MENSAJE",JOptionPane.INFORMATION_MESSAGE);*/
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;
			
		}
		
}
