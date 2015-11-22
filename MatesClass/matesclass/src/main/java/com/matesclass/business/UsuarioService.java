package com.matesclass.business;

import com.matesclass.persistence.dao.UsuarioDAO;
import com.matesclass.persistence.model.Usuario;

public class UsuarioService {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public String insertarUsuario(String idUsuario, String pass, String email){
		return usuarioDAO.insertarUsuario(idUsuario,pass,email);
	}
	
	public Usuario loginUsuario(String idUsuario, String pass) {
		return usuarioDAO.loginUsuario(idUsuario,pass);
	}
}
