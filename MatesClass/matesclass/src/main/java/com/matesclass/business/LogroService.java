package com.matesclass.business;

import java.util.ArrayList;


import com.matesclass.persistence.dao.LogroDAO;

public class LogroService{
	
	private LogroDAO logroDAO = new LogroDAO();


	public void insertarLogro(String idUsuario, Long idLogro) {
		logroDAO.insertarLogro(idUsuario, idLogro);
	}
	
	public ArrayList<Long> listarLogros(String idUsuario) {
		return logroDAO.listarLogros(idUsuario);
	}
	
}
