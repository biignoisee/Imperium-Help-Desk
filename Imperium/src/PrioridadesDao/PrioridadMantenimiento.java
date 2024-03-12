package PrioridadesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.IPrioridadInterface;
import Models.ReadPrioridad;

public class PrioridadMantenimiento implements IPrioridadInterface{

	@Override
	public List<ReadPrioridad> readPrioridades() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ReadPrioridad> listaPrioridades = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT id, nombre FROM tbl_prioridades";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			listaPrioridades = new ArrayList<ReadPrioridad>();
			
			while(rs.next()) {
				ReadPrioridad readPrioridadDto = new ReadPrioridad();
				readPrioridadDto.setId(rs.getInt(1));
				readPrioridadDto.setNombre(rs.getString(2));
				
				listaPrioridades.add(readPrioridadDto);
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener el listado de prioridades : " + e.getMessage());
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
		return listaPrioridades;
	}

}
