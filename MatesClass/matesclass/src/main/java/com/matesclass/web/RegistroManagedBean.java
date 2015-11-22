package com.matesclass.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.matesclass.business.UsuarioService;


@ManagedBean(name = "RegistroMB")
@ViewScoped
public class RegistroManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5496493838370967141L;

	private UsuarioService usuarioService = new UsuarioService();
	
	private String idUsuario;
	private String pass;
	private String email;
	private String msgExito;
	
	@PostConstruct
	public void init() {
		
	}

	public void guardarUsuario(){
		setMsgExito(usuarioService.insertarUsuario(idUsuario, pass, email));
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsgExito() {
		return msgExito;
	}

	public void setMsgExito(String msgExito) {
		this.msgExito = msgExito;
	}
	
	
}
