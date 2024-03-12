package CategoriaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.ICategoriaInterface;
import Models.ReadCategoria;

public class CategoriaMantenimiento implements ICategoriaInterface{

	@Override
	public List<ReadCategoria> getCategorias() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ReadCategoria> listaCategorias = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT id, nombre FROM tbl_categorias";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			listaCategorias = new ArrayList<ReadCategoria>();
			
			while(rs.next()) {
				ReadCategoria readCategoriaDto = new ReadCategoria();
				readCategoriaDto.setId(rs.getInt(1));
				readCategoriaDto.setNombre(rs.getString(2));
				listaCategorias.add(readCategoriaDto);
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener el listado de categorias : " + e.getMessage());
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
		return listaCategorias;
	}
	
}
