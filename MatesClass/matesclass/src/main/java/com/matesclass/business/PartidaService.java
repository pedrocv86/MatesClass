package com.matesclass.business;

import java.util.List;

import com.matesclass.persistence.dao.PartidaDAO;
import com.matesclass.persistence.model.Partida;

public class PartidaService {

	private PartidaDAO partidaDAO = new PartidaDAO();

	public void crearPartida(String nombrePartida, String idUsuario,
			String progreso, String codProgreso) {
		partidaDAO.crearPartida(nombrePartida, idUsuario, progreso, codProgreso);
	}
	
	public List<Partida> listarPartidas(String idUsuario) {
		
		return partidaDAO.listarPartidas(idUsuario);
	}
	
	public void eliminarPartida(Long idPartida) {
		partidaDAO.eliminarPartida(idPartida);
	}
}
