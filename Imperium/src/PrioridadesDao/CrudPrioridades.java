package PrioridadesDao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ConectarBD_MYSQL.ConectarMYSQL;
import Models.ClasePrioridades;

public class CrudPrioridades implements Interfaces.IntPrioridable{

	@Override
	public void registrar(ClasePrioridades claspri) {
		ConectarMYSQL conex = new ConectarMYSQL();
		//cadena de MYSQL
		String SQL="CALL SP_INSERT_PRIORIDAD (?)";
		//aplicamos la interfaz CallableStatement...
		CallableStatement pstregistrar=null;
		
		//asiganamos la conexion 
		try {
			pstregistrar = conex.getConnection().prepareCall(SQL);
			
			//mandamos los valores
			pstregistrar.setString(1, claspri.getNombre_prioridad());
			
			//ejecutar y guardar en la base de datosl...
			int x=pstregistrar.executeUpdate();
			//aplicamos un condicion...
			if(x>0){
				//emitimos un mensaje por consola
				System.out.println("Registro guardado en la BASE DE DATOS");
				
			}else{
				//emitimos un mensaje por consola
				System.out.println("Registro NO GUARDADO en la BASE DE DATOS");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizar(ClasePrioridades claspri) {
		ConectarMYSQL conex = new ConectarMYSQL();
		
		//cadena de SQL
		String SQL = "CALL SP_UPDATE_PRIORIDAD (?,?);";
		//
		CallableStatement pst=null;
		//asiganmos nuestra conexion con la base de datos
		try {
			pst = conex.getConnection().prepareCall(SQL);
	
			//mandamos los valores
			pst.setInt(1, claspri.getId());
			pst.setString(2, claspri.getNombre_prioridad());
			
			//ejecutamos la consulta
			int x=pst.executeUpdate();
			
			if(x>0){
				//imprimimos un mensaje de pantalla
				System.out.println("DATOS ACTUALIZADOS CORRECTAMNTE EN LA BAE DE DATOS");
			}else{
				//emitimos un mensaje por pantalla
				System.out.println("DATOS NO ACTUALIZADOS CORRECTAMENTE EN LA BD");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(ClasePrioridades claspri) {
		ConectarMYSQL conex = new ConectarMYSQL();
		
		//consulta 
		String SQL = "CALL SP_ELIMINAR_PRIORIDAD(?);";
		
		CallableStatement pst=null;
		//obtenemos la coonexion y mandamos la cosulta a la base de datos
		try {
			pst= conex.getConnection().prepareCall(SQL);
 
			//mandamos el vlalore requerido
			pst.setInt(1, claspri.getId());
			
			//ejecutamos el metodo execute..			
			int y = pst.executeUpdate();
			
			
			if(y>0){
				//emitimos un mensaje por consola
				System.out.println("Prioridad inhabilitada del sistema.");
			
			}else{
				//emitimos un mensaje por consola
				System.out.println("Falló al inhabilitar prioridad.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ClasePrioridades> ListarPrioridades() {
		ConectarMYSQL conex = new ConectarMYSQL();
		
		//cadena de consulta sql
		String SQLLISTAR ="call SP_SELECT_PRIORIDAD();";
		//aplicamos las interfaces
		CallableStatement pst=null;
        ResultSet rs=null;
		//arraylist
        List<ClasePrioridades> listprioridades = new ArrayList<ClasePrioridades>();
        
        //obtenemos la conexion y mandamos la consulta
        try {
			pst =  conex.getConnection().prepareCall(SQLLISTAR);

			rs=pst.executeQuery();
			
			while(rs.next()){
				ClasePrioridades clpri = new ClasePrioridades();
				clpri.setId(rs.getInt(1));
				clpri.setNombre_prioridad(rs.getString(2));
				clpri.setEstado(rs.getInt(3));
				listprioridades.add(clpri);
			}
			
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
		return listprioridades;
	}

	@Override
	public ClasePrioridades buscarprioridades(ClasePrioridades buscpri) {
		ConectarMYSQL conex = new ConectarMYSQL();
		
		String SQL = "call SP_LISTAR_ID_PRIORIDAD(?);";
		
		CallableStatement pst=null;
		ResultSet rs=null;
		//llamams a la clase
		ClasePrioridades clpri = new ClasePrioridades();
		
		//obtenemos la conexion y mandamos la consulta
		try {
			pst=conex.getConnection().prepareCall(SQL);
		
			pst.setInt(1, buscpri.getId());
			//vinculamos con la clase resulset...
			rs=pst.executeQuery(); //aplicamos una conexion 
			
			if(rs.next()){
				clpri.setId(rs.getInt(1));
				clpri.setNombre_prioridad(rs.getString(2));
				clpri.setEstado(rs.getInt(3));
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return clpri;
	}

}
