package SubCategoriaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.ISubcategoriaInterface;
import Models.ReadSubcategoria;

public class SubcategoriaMantenimiento implements ISubcategoriaInterface{

	@Override
	public List<ReadSubcategoria> getSubcategoriasByCategoria(int categoriaId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ReadSubcategoria> listaSubcategorias = null;
		
		try {
			con = ConectarMYSQL.getConnection();
			String sql = "SELECT id, nombre FROM tbl_subcategorias WHERE categoria_id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, categoriaId);
			
			rs = pst.executeQuery();
			listaSubcategorias = new ArrayList<ReadSubcategoria>();
			
			while(rs.next()) {
				ReadSubcategoria readSubcategoriaDto = new ReadSubcategoria();
				readSubcategoriaDto.setId(rs.getInt(1));
				readSubcategoriaDto.setNombre(rs.getString(2));
				listaSubcategorias.add(readSubcategoriaDto);
			}
			
		} catch (Exception e) {
			System.out.print("Error al obtener el listado de subcategorias : " + e.getMessage());
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
		return listaSubcategorias;
	}

}
