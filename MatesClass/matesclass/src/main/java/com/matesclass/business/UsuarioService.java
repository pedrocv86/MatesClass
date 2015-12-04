package com.matesclass.business;

import java.io.Serializable;
import java.sql.SQLException;

import com.matesclass.persistence.dao.UsuarioDAO;
import com.matesclass.persistence.model.Usuario;

public class UsuarioService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5617864972358359617L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public String insertarUsuario(String idUsuario, String pass, String email)  throws SQLException {
		return usuarioDAO.insertarUsuario(idUsuario,pass,email);
	}
	
	public Usuario loginUsuario(String idUsuario, String pass) {
		return usuarioDAO.loginUsuario(idUsuario,pass);
	}
}
