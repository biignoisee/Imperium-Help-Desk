package CategoriaDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConectarBD_MYSQL.ConectarMYSQL;
import Interfaces.IntCategoriaAble;
import Models.Categoria;

public class CrudCategoriaImp implements IntCategoriaAble {

	@Override
	public void RegistrarCategoria(Categoria clcat) {
		// instanciar la clase conectar...
		// realizamos la cadena en sql
		String sql = "INSERT INTO TBL_CATEGORIAS VALUES (null, ?, ?)";
		// aplicamos la interfaz preparedstatement...
		PreparedStatement pst = null;

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			// asignamos los respectivos parametros..
			// pst.setInt(1, clcat.getId());
			pst.setString(1, clcat.getNombre());
			pst.setInt(2, clcat.getEstado());

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
	public void ActualizarCategoria(Categoria clcat) {
		// Consulta SQL
		String sql = "UPDATE TBL_CATEGORIAS SET nombre = ?, estado = ? where id = ?";

		// Usamos las interfaces para la BD
		PreparedStatement pst = null;

		// Asignamos la conexion de la BD y la cadena
		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);

			// Asignamos los valores
			pst.setString(1, clcat.getNombre());
			pst.setInt(2, clcat.getEstado());
			pst.setInt(3, clcat.getId());

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
	public void EliminarCategoria(Categoria clcat) {
		String sql = "DELETE FROM TBL_CATEGORIAS WHERE ID = ?";

		PreparedStatement pst = null;

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);

			// Asignamos el parámetro
			pst.setInt(1, clcat.getId());

			// Ejecutamos el método execute
			int y = pst.executeUpdate();

			// Condicion
			if (y > 0) {
				System.out.println("Categoria Eliminada");
			} else {
				System.out.println("Categoria Eliminada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // fin del metodo eliminar

	@Override
	public List<Categoria> ListarCategoria() {
		String sqllistar = "select * from tbl_categorias";

		// aplicamos las interfaces
		PreparedStatement pst = null;
		ResultSet rs = null;

		// para almacenar valores de la base de datos...
		List<Categoria> listado_categoria = new ArrayList<Categoria>();

		try {
			pst = ConectarMYSQL.getConnection().prepareStatement(sqllistar);
			rs = pst.executeQuery();
			while (rs.next()) {
				Categoria lstcat = new Categoria();
				lstcat.setId(rs.getInt(1));
				lstcat.setNombre(rs.getString(2));
				lstcat.setEstado(rs.getInt(3));

				listado_categoria.add(lstcat);
			} // fin del bucle while...

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// retornamos los valores
		return listado_categoria;
	}

	@Override
	public Categoria BuscarCategoria(Categoria buscat) {
		// realizamos la respectiva cadena...
		String sql = "SELECT * FROM TBL_CATEGORIAS WHERE ID = ?";

		PreparedStatement pst = null;
		ResultSet rs = null;

		Categoria busCat = new Categoria();

		try {
			// asignamos la conexión y la cadena a la variable pst
			pst = ConectarMYSQL.getConnection().prepareStatement(sql);
			pst.setInt(1, buscat.getId());

			rs = pst.executeQuery();

			if (rs.next()) {
				busCat.setId(rs.getInt(1));
				busCat.setNombre(rs.getString(2));
				busCat.setEstado(rs.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busCat;
	}

}
