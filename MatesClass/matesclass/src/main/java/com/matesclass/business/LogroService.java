package com.matesclass.business;

import java.io.Serializable;
import java.util.ArrayList;



import com.matesclass.persistence.dao.LogroDAO;

public class LogroService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5448328310512352826L;
	
	private LogroDAO logroDAO = new LogroDAO();


	public void insertarLogro(String idUsuario, Long idLogro) {
		logroDAO.insertarLogro(idUsuario, idLogro);
	}
	
	public ArrayList<Long> listarLogros(String idUsuario) {
		return logroDAO.listarLogros(idUsuario);
	}
	
}
