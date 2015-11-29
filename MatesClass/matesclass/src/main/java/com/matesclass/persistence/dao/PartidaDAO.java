package com.matesclass.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.matesclass.persistence.model.Partida;

@Repository
public class PartidaDAO extends GenericDAO {

	public Partida crearPartida(String nombrePartida, String idUsuario,
			String progreso, String codProgreso) {
		Partida partida = new Partida();

		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		String nowDate = df.format(new Date());

		try {
			String consulta = "INSERT INTO PARTIDA (NOMBRE_PARTIDA, FH_CREACION, PUNTUACION, PROGRESO, ID_USUARIO, COD_PROGRESO)"
					+ " VALUES ('" + nombrePartida + "', '" + nowDate + "', '0', '"
					+ progreso + "', '" + idUsuario + "', '" + codProgreso + "')";
			consultaDB().executeUpdate(consulta);

			String returnPartida = "SELECT * FROM PARTIDA WHERE ID_PARTIDA = "
					+ "(SELECT MAX(ID_PARTIDA) FROM PARTIDA)";
			ResultSet rs = consultaDB().executeQuery(returnPartida);

			while (rs.next()) {
				partida.setIdPartida(rs.getLong("ID_PARTIDA"));
				partida.setNombrePartida(rs.getString("NOMBRE_PARTIDA"));
				partida.setFhCreacion(rs.getDate("FH_CREACION"));
				partida.setPuntuacion(rs.getLong("PUNTUACION"));
				partida.setProgreso(rs.getString("PROGRESO"));
				partida.setIdUsuario(rs.getString("ID_USUARIO"));
				partida.setCodProgreso(rs.getString("COD_PROGRESO"));
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

		return partida;
	}

	public ArrayList<Partida> listarPartidas(String idUsuario) {
		ArrayList<Partida> listaPartidas = new ArrayList<Partida>();
		try {
			String consulta = "SELECT * FROM PARTIDA WHERE ID_USUARIO='"
					+ idUsuario + "' ORDER BY FH_CREACION";
			ResultSet rs = consultaDB().executeQuery(consulta);
			while (rs.next()) {
				Partida partida = new Partida();
				partida.setIdPartida(rs.getLong("ID_PARTIDA"));
				partida.setNombrePartida(rs.getString("NOMBRE_PARTIDA"));
				partida.setFhCreacion(rs.getDate("FH_CREACION"));
				partida.setPuntuacion(rs.getLong("PUNTUACION"));
				partida.setProgreso(rs.getString("PROGRESO"));
				partida.setIdUsuario(rs.getString("ID_USUARIO"));
				partida.setCodProgreso(rs.getString("COD_PROGRESO"));

				listaPartidas.add(partida);
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

		return listaPartidas;
	}

	public void eliminarPartida(Long idPartida) {
		try {
			String consulta = "DELETE FROM PARTIDA WHERE ID_PARTIDA='"
					+ idPartida + "'";
			consultaDB().executeUpdate(consulta);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consultaDB().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void cambiarPuntuacion(Long idPartida, Long puntos) {
		try {
			String consulta = "UPDATE PARTIDA SET PUNTUACION=(PUNTUACION + ("
					+ puntos + ")) WHERE ID_PARTIDA=" + idPartida;
			consultaDB().executeUpdate(consulta);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consultaDB().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Long cargarPuntuacion(Long idPartida) {
		Long puntuacion = null;
		try {
			String consulta = "SELECT PUNTUACION FROM PARTIDA WHERE ID_PARTIDA='"
					+ idPartida + "'";
			ResultSet rs = consultaDB().executeQuery(consulta);

			while (rs.next()) {
				puntuacion = rs.getLong("PUNTUACION");
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
		return puntuacion;

	}
	
	public void guardarProgreso(Long idPartida, Long puntos, String progreso, String codProgreso) {
		try {
			String consulta = "UPDATE PARTIDA SET PROGRESO='" + progreso 
					+ "', COD_PROGRESO='" + codProgreso + "', PUNTUACION=(PUNTUACION + ("
					+ puntos + ")) WHERE ID_PARTIDA=" + idPartida;
			consultaDB().executeUpdate(consulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consultaDB().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
