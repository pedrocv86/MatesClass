package com.matesclass.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class LogroDAO extends GenericDAO {

	public void insertarLogro(String idUsuario, Long idLogro) {

		try {
			String consulta = "INSERT INTO USU_LOGRO (ID_LOGRO, ID_USUARIO)"
					+ " VALUES ('" + idLogro + "', '" + idUsuario + "')";
			consultaDB().executeUpdate(consulta);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Long> listarLogros(String idUsuario) {
		ArrayList<Long> listaLogros = new ArrayList<Long>();
		try {
			String consulta = "SELECT ID_LOGRO FROM USU_LOGRO "
					+ "WHERE ID_USUARIO='" + idUsuario + "'";
			ResultSet rs = consultaDB().executeQuery(consulta);
			while (rs.next()) {
				Long logro = rs.getLong("ID_LOGRO");
				listaLogros.add(logro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consultaDB().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaLogros;
	}

}
