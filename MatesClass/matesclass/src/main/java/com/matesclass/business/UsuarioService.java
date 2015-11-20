package com.matesclass.business;

import com.matesclass.persistence.dao.UsuarioDAO;

public class UsuarioService {

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void insertarUsuario(){
		usuarioDAO.insertarUsuario();
	}
}
