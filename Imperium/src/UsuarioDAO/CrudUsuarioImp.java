package UsuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.IntUsuarioable;
import Models.ClassUsuario;
import Models.ReadUsuarioSoporte;

public class CrudUsuarioImp implements IntUsuarioable{

	public ClassUsuario loginUsuario(ClassUsuario classusuario){
		ConectarMYSQL conex = new ConectarMYSQL();
		String sql = "SELECT * FROM TBL_USUARIOS WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ClassUsuario cubd = new ClassUsuario();
		try {
			ps = conex.getConnection().prepareStatement(sql);
			ps.setString(1, classusuario.getUsername());
			ps.setString(2,classusuario.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				cubd.setId(rs.getInt(1));
				cubd.setNombre(rs.getString(2));
				cubd.setApellido_paterno(rs.getString(3));
				cubd.setApellido_materno(rs.getString(4));
				cubd.setDni(rs.getString(5));
				cubd.setUsername(rs.getString(2));
				cubd.setPassword(rs.getString(3));
				cubd.setRole_id(rs.getInt(8));
				cubd.setEstado(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cubd;
	}
	
	@Override
	public void RegistrarUsuario(ClassUsuario clusu) {
		// Instanciar la clase conectar...
		// Realizamos la cadena en sql
		String sql = "INSERT INTO TBL_USUARIOS VALUES (null, ?, ?, ?, ?, ?, ?, ?, 1)";
		// Aplicamos la interfaz preparedstatement...
		PreparedStatement pst = null;
				
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			//asignamos los respectivos parametros			
			pst.setString(1, clusu.getNombre());
			pst.setString(2, clusu.getApellido_paterno());
			pst.setString(3, clusu.getApellido_materno());
			pst.setString(4, clusu.getDni());
			pst.setString(5, clusu.getUsername());
			pst.setString(6, clusu.getPassword());
			pst.setInt(7, clusu.getRole_id());
			
			// Ejecutar y guardar en la base de datos...
			int x = pst.executeUpdate();
			
			//aplicamos un condicion...
			if(x > 0){
				System.out.println("Registro guardado en la BASE DE DATOS");
						
			}else{
				System.out.println("Registro NO GUARDADO en la BASE DE DATOS");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ActualizarUsuario(ClassUsuario clusu) {
		// Consulta SQL
		String sql = "UPDATE TBL_USUARIOS SET NOMBRE = ?, APELLIDO_PATERNO = ?, APELLIDO_MATERNO = ?, DNI = ?, USERNAME = ?, PASSWORD = ?, ROLE_ID = ?, ESTADO = 1 WHERE ID = ?";
				
		// Usamos las interfaces para la BD
		PreparedStatement pst = null;
				
		// Asignamos la conexion de la BD y la cadena
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			
			// Asignamos los valores		
			pst.setString(1, clusu.getNombre());
			pst.setString(2, clusu.getApellido_paterno());
			pst.setString(3, clusu.getApellido_materno());
			pst.setString(4, clusu.getDni());
			pst.setString(5, clusu.getUsername());
			pst.setString(6, clusu.getPassword());
			pst.setInt(7, clusu.getRole_id());
			pst.setInt(8, clusu.getId());
					
			// Ejecutamos la consulta y actualizamos la data en la BD
			int x = pst.executeUpdate();
					
			// Aplicamos condicion
			if (x > 0){
				System.out.println("Datos actualizados correctamente en la BD.");
			} else {
				System.out.println("Los datos NO se actualizaron.");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void EliminarUsuario(ClassUsuario clusu) {
		String sql = "UPDATE TBL_USUARIOS SET ESTADO = 0 WHERE id = ?";
		
		PreparedStatement pst = null;
		
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			
			// Asignamos el parámetro
			pst.setInt(1, clusu.getId());
			
			// Ejecutamos el método execute
			int y = pst.executeUpdate();
			
			// Condicion
			if (y > 0){
				System.out.println("Usuario inhabilitado exitosamente.");
			}else {
				System.out.println("El usuario NO se inhabilitó.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ClassUsuario> ListarUsuario() {
		String sql = "SELECT * FROM TBL_USUARIOS";
		
		PreparedStatement pst = null;
		
		ResultSet rs = null;
		
		List<ClassUsuario> listado_usuarios = new ArrayList<ClassUsuario>();  
		ClassUsuario clausu = null;
		        
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				clausu = new ClassUsuario();
				clausu.setId(rs.getInt(1));
				clausu.setNombre(rs.getString(2));
				clausu.setApellido_paterno(rs.getString(3));
				clausu.setApellido_materno(rs.getString(4));
				clausu.setDni(rs.getString(5));
				clausu.setUsername(rs.getString(6));
				clausu.setPassword(rs.getString(7));
				clausu.setRole_id(rs.getInt(8));
				clausu.setEstado(rs.getInt(9));
				listado_usuarios.add(clausu);
			}  //fin del bucle while...
					
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		  //retornamos los valores
		return listado_usuarios;
	}

	@Override
	public ClassUsuario BuscarUsuario(ClassUsuario bususu) {
		String sql = "SELECT * FROM TBL_USUARIOS WHERE ID = ?";
				
		PreparedStatement pst = null;
		ResultSet rs = null;
				
		ClassUsuario busu = new ClassUsuario();
				
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			pst.setInt(1, bususu.getId());
					
			rs = pst.executeQuery();
					
			if (rs.next()){
				busu.setId(rs.getInt(1));				;
				busu.setNombre(rs.getString(2));
				busu.setApellido_paterno(rs.getString(3));
				busu.setApellido_materno(rs.getString(4));
				busu.setDni(rs.getString(5));
				busu.setUsername(rs.getString(6));
				busu.setPassword(rs.getString(7));
				busu.setRole_id(rs.getInt(8));
				busu.setEstado(rs.getInt(9));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busu;
	}

	@Override
	public List<ReadUsuarioSoporte> readUsuariosSoporte() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ReadUsuarioSoporte> usuariosSoporte = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT U.id, U.nombre, U.apellido_paterno, U.apellido_materno, U.dni, COUNT(I.id) FROM tbl_usuarios AS U " +  
						 "LEFT JOIN tbl_incidencias AS I ON U.id = I.usuario_id " + 
						 "WHERE U.role_id = 2 " + 
						 "GROUP BY U.id";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			usuariosSoporte = new ArrayList<ReadUsuarioSoporte>();
			
			while(rs.next()) {
				ReadUsuarioSoporte readUsuarioSoporte = new ReadUsuarioSoporte();
				readUsuarioSoporte.setId(rs.getInt(1));
				readUsuarioSoporte.setNombre(rs.getString(2));
				readUsuarioSoporte.setApellidoPaterno(rs.getString(3));
				readUsuarioSoporte.setApelidoMaterno(rs.getString(4));
				readUsuarioSoporte.setDni(rs.getString(5));
				readUsuarioSoporte.setCantidadIncidencias(rs.getInt(6));
				usuariosSoporte.add(readUsuarioSoporte);
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener el listado de usuarios de soporte : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuariosSoporte;
	}
	
}
