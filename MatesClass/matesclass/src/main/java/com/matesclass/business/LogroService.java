package com.matesclass.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matesclass.persistence.dao.LogroDAO;

@Service("logroService")
public class LogroService{
	
	@Autowired
	LogroDAO logroDAO = new LogroDAO();

	
	public String probarCapas(String text) {
		return logroDAO.probarCapas(text);
	}


	public LogroDAO getLogroDAO() {
		return logroDAO;
	}


	public void setLogroDAO(LogroDAO logroDAO) {
		this.logroDAO = logroDAO;
	}

}
