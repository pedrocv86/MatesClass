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

	public void crearPartida(String nombrePartida, String idUsuario,
			String progreso, String codProgreso) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yy");
			String nowDate = df.format(new Date());
			String consulta = "INSERT INTO PARTIDA (NOMBRE_PARTIDA, FH_CREACION, PUNTUACION, PROGRESO, ID_USUARIO, COD_PROGRESO)"
					+ " VALUES ('"
					+ nombrePartida
					+ "', '"
					+ nowDate
					+ "', '0', '"
					+ progreso
					+ "', '"
					+ idUsuario
					+ "', '"
					+ codProgreso + "')";
			consultaDB().executeUpdate(consulta);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Partida> listarPartidas(String idUsuario) {
		ArrayList<Partida> listaPartidas = new ArrayList<Partida>();
		try {
			String consulta = "SELECT * FROM PARTIDA WHERE ID_USUARIO='"
					+ idUsuario + "'";
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPartidas;
	}
	
	public void eliminarPartida(Long idPartida) {
		try {
			String consulta = "DELETE FROM PARTIDA WHERE ID_PARTIDA='" + idPartida + "'";
			consultaDB().executeUpdate(consulta);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
