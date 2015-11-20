package com.matesclass.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository
public class LogroDAO extends GenericDAO {

	public LogroDAO(){
		
	}
	
	public String probarCapas(String text){
		String texto = text + " OK";
		return texto;
	}

}
