package SubCategoriaDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.IntSubCategoriaAble;
import Models.SubCategoria;

public class CrudSubCategoriaImp implements IntSubCategoriaAble {

	@Override
	public void RegistrarSubCategoria(SubCategoria clsbcat) {
		// instanciar la clase conectar...
		// realizamos la cadena en sql
		String sql = "INSERT INTO TBL_SUBCATEGORIAS VALUES (null, ?, ?, ?)";
		// aplicamos la interfaz preparedstatement...
		PreparedStatement pst = null;

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			// asignamos los respectivos parametros..
			// pst.setInt(1, clsbcat.getId());
			pst.setInt(1, clsbcat.getCategoria_id());
			pst.setString(2, clsbcat.getNombre());
			pst.setInt(3, clsbcat.getEstado());

			// Ejecutar y guardar en la base de datos...
			int x = pst.executeUpdate();

			// aplicamos un condicion...
			if (x > 0) {
				System.out.println("Registro guardado en la BASE DE DATOS");

			} else {
				System.out.println("Registro NO GUARDADO en la BASE DE DATOS");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // fin del metodo registrar

	@Override
	public void ActualizarSubCategoria(SubCategoria clsbcat) {
		// Consulta SQL
		String sql = "UPDATE TBL_SUBCATEGORIAS SET categoria_id = ?, nombre = ?, estado = ? where id = ?";

		// Usamos las interfaces para la BD
		PreparedStatement pst = null;

		// Asignamos la conexion de la BD y la cadena
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);

			// Asignamos los valores
			pst.setInt(1, clsbcat.getCategoria_id());
			pst.setString(2, clsbcat.getNombre());
			pst.setInt(3, clsbcat.getEstado());
			pst.setInt(4, clsbcat.getId());

			// Ejecutamos la consulta y actualizamos la data en la BD
			int x = pst.executeUpdate();

			// Aplicamos condicion
			if (x > 0) {
				System.out.println("Datos actualizados correctamente en la BD.");
			} else {
				System.out.println("Los datos NO se actualizaron.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // fin del metodo actualizar

	@Override
	public void EliminarSubCategoria(SubCategoria clsbcat) {
		String sql = "DELETE FROM TBL_SUBCATEGORIAS WHERE ID = ?";

		PreparedStatement pst = null;

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);

			// Asignamos el parámetro
			pst.setInt(1, clsbcat.getId());

			// Ejecutamos el método execute
			int y = pst.executeUpdate();

			// Condicion
			if (y > 0) {
				System.out.println("SubCategoria Eliminada");
			} else {
				System.out.println("SubCategoria Eliminada");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // fin del metodo eliminar

	@Override
	public List<SubCategoria> ListarSubCategoria() {
		String sql = "SELECT * FROM TBL_SUBCATEGORIAS";

		PreparedStatement pst = null;

		ResultSet rs = null;

		List<SubCategoria> listado_subcategorias = new ArrayList<SubCategoria>();

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				SubCategoria clasbcat = new SubCategoria();
				clasbcat.setId(rs.getInt(1));
				clasbcat.setCategoria_id(rs.getInt(2));
				clasbcat.setNombre(rs.getString(3));
				clasbcat.setEstado(rs.getInt(4));

				listado_subcategorias.add(clasbcat);
			} // fin del bucle while...

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// retornamos los valores
		return listado_subcategorias;
	}

	@Override
	public SubCategoria BuscarSubCategoria(SubCategoria bussbcat) {
		String sql = "SELECT * FROM TBL_SUBCATEGORIAS WHERE ID = ?";

		PreparedStatement pst = null;
		ResultSet rs = null;

		SubCategoria busSbCat = new SubCategoria();

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			pst.setInt(1, bussbcat.getId());

			rs = pst.executeQuery();

			if (rs.next()) {
				busSbCat.setId(rs.getInt(1));
				busSbCat.setCategoria_id(rs.getInt(2));
				busSbCat.setNombre(rs.getString(3));
				busSbCat.setEstado(rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busSbCat;
	}

}
