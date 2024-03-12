package incidenciaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.IIncidenciaInterface;
import Models.CreateDocumentoIncidencia;
import Models.CreateImagenIncidencia;
import Models.CreateIncidencia;
import Models.ReadIncidencia;
import Models.ReadIncidenciaById;

public class IncidenciaMantenimiento implements IIncidenciaInterface{

	@Override
	public List<ReadIncidencia> readIncidencias() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ReadIncidencia> listaIncidencias = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT " + 
							"I.id," +  
						    "C.nombre AS 'categoria'," +  
						    "I.titulo," +  
						    "P.nombre AS 'prioridad'," +  
						    "I.fecha_creacion," + 
						    "I.fecha_asignacion," + 
						    "I.fecha_cierre, " + 
						    "I.usuario_id " + 
						    "FROM tbl_incidencias AS I " +  
						"INNER JOIN tbl_subcategorias AS S ON I.subcategoria_id = S.id " + 
						"INNER JOIN tbl_categorias AS C ON S.categoria_id = C.id " + 
						"INNER JOIN tbl_prioridades AS P ON I.prioridad_id = P.id "+ 
						"ORDER BY I.fecha_creacion DESC";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			listaIncidencias = new ArrayList<ReadIncidencia>();
			
			while(rs.next()) {
				ReadIncidencia incidencia = new ReadIncidencia();
				incidencia.setId(rs.getInt(1));
				incidencia.setCategoria(rs.getString(2));
				incidencia.setTitulo(rs.getString(3));
				incidencia.setPrioridad(rs.getString(4));
				incidencia.setFechaCreacion(rs.getDate(5));
				incidencia.setFechaAsignacion(rs.getDate(6));
				incidencia.setFechaCierre(rs.getDate(7));
				incidencia.setUsuario(rs.getString(8));
				
				listaIncidencias.add(incidencia);
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener el listado de incidencias : " + e.getMessage());
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
		return listaIncidencias;
	}
	
	@Override
	public void createIncidencia(CreateIncidencia incidencia, 
								 List<CreateDocumentoIncidencia> documentos,
								 List<CreateImagenIncidencia> imagenes) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int incidenciaId = 0;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "INSERT INTO tbl_incidencias "
						+ "(titulo, subcategoria_id, prioridad_id, descripcion, fecha_creacion)"
						+ "VALUES(?,?,?,?,?)";
			con.setAutoCommit(false);
			
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, incidencia.getTitulo());
			pst.setInt(2, incidencia.getSubcategoriaId());
			pst.setInt(3, incidencia.getPrioridadId());
			pst.setString(4, incidencia.getDescripcion());
			pst.setDate(5, new java.sql.Date(incidencia.getFechaCreacion().getTime()));
			
			pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			
			if(rs.next()) {
				incidenciaId = rs.getInt(1);
			}
			
			if(documentos.size() != 0) {
				for (CreateDocumentoIncidencia documento : documentos) {
					String sql3 = "INSERT INTO tbl_documentos_incidencias (documento, incidencia_id)"
							+ "VALUES(?,?)";
					
					pst = con.prepareStatement(sql3);
					pst.setString(1, documento.getDocumento());
					pst.setInt(2, incidenciaId);
					pst.executeUpdate();
				}
			}
			
			if(imagenes.size() != 0) {
				for (CreateImagenIncidencia imagen : imagenes) {
					String sql2 = "INSERT INTO tbl_imagenes_incidencias(imagen, incidencia_id)"
							+ "VALUES(?,?)";
					
					pst = con.prepareStatement(sql2);
					pst.setString(1, imagen.getImagen());
					pst.setInt(2, incidenciaId);
					pst.executeUpdate();
				}
			}
			
			con.commit();
			
		} catch (Exception e) {
			System.out.print("Error al crear la incidencia : " + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	}

	@Override
	public ReadIncidenciaById readIncidenciaById(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ReadIncidenciaById incidencia = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT " + 
							"I.id," +  
						    "CONCAT(U.nombre, ' ', U.apellido_paterno, ' ', U.apellido_materno)," +  
						    "I.titulo," +  
						    "I.descripcion," + 
						    "I.fecha_creacion, " +  
						    "GROUP_CONCAT(DISTINCT DI.documento), " + 
						    "GROUP_CONCAT(DISTINCT II.imagen) " +  
						"FROM tbl_incidencias AS I " + 
						"LEFT JOIN tbl_usuarios AS U ON I.usuario_id = U.id " + 
						"LEFT JOIN tbl_documentos_incidencias AS DI ON I.id = DI.incidencia_id " + 
						"LEFT JOIN tbl_imagenes_incidencias AS II ON I.id = II.incidencia_id " + 
						"WHERE I.id = ? " + 
						"GROUP BY I.id, U.nombre, U.apellido_paterno, U.apellido_materno, I.titulo, I.fecha_creacion";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				incidencia = new ReadIncidenciaById();
				incidencia.setId(rs.getInt(1));
				incidencia.setNombreSoporte(rs.getString(2));
				incidencia.setTitulo(rs.getString(3));
				incidencia.setDescripcion(rs.getString(4));
				incidencia.setFechaRegistro(rs.getDate(5));
				incidencia.setDocumentos(rs.getString(6));
				incidencia.setImagenes(rs.getString(7));
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener la incidencia : " + e.getMessage());
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
		return incidencia;
	}

	@Override
	public List<ReadIncidencia> readIndidenciasByFilter(int categoriaId, int prioridadId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ReadIncidencia> listaIncidencias = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT " + 
							"I.id," +  
						    "C.nombre AS 'categoria'," +  
						    "I.titulo," +  
						    "P.nombre AS 'prioridad'," +  
						    "I.fecha_creacion," + 
						    "I.fecha_asignacion," + 
						    "I.fecha_cierre, " +
						    "I.usuario_id " + 
						    "FROM tbl_incidencias AS I " +  
						"INNER JOIN tbl_subcategorias AS S ON I.subcategoria_id = S.id " + 
						"INNER JOIN tbl_categorias AS C ON S.categoria_id = C.id " + 
						"INNER JOIN tbl_prioridades AS P ON I.prioridad_id = P.id "+ 
						"WHERE (C.id = ? OR ? = 0) AND (P.id = ? OR ? = 0) " +
						"ORDER BY I.fecha_creacion DESC";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, categoriaId);
			pst.setInt(2, categoriaId);
			pst.setInt(3, prioridadId);
			pst.setInt(4, prioridadId);
			
			rs = pst.executeQuery();
			listaIncidencias = new ArrayList<ReadIncidencia>();
			
			while(rs.next()) {
				ReadIncidencia incidencia = new ReadIncidencia();
				incidencia.setId(rs.getInt(1));
				incidencia.setCategoria(rs.getString(2));
				incidencia.setTitulo(rs.getString(3));
				incidencia.setPrioridad(rs.getString(4));
				incidencia.setFechaCreacion(rs.getDate(5));
				incidencia.setFechaAsignacion(rs.getDate(6));
				incidencia.setFechaCierre(rs.getDate(7));
				incidencia.setUsuario(rs.getString(8));
				
				listaIncidencias.add(incidencia);
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener el listado de incidencias : " + e.getMessage());
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
		return listaIncidencias;
	}

	@Override
	public void eliminarUsuarioAsignadoIncidencia(int incidenciaId) {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "UPDATE tbl_incidencias SET usuario_id = NULL, fecha_asignacion = NULL WHERE id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, incidenciaId);
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.print("Error al eliminar el usuario asignado a la incidencia : " + e.getMessage());
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
	}

	@Override
	public void asignarUsuarioSoporteIncidencia(int incidenciaId, int usuarioId) {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "UPDATE tbl_incidencias SET usuario_id = ?, fecha_asignacion = ? WHERE id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, usuarioId);
			pst.setDate(2, new java.sql.Date(new Date().getTime()));
			pst.setInt(3, incidenciaId);
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.print("Error al asignar usuario de soporte a incidencia : " + e.getMessage());
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
	}

}
