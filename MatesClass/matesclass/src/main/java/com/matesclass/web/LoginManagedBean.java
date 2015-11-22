package com.matesclass.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.matesclass.business.UsuarioService;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2911220009370262740L;

	private UsuarioService usuarioService = new UsuarioService();
	
	private String idUsuario;
	private String pass;
	private Usuario usuario;
	
	
	@PostConstruct
	public void init() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public String loginUsuario(){
		setUsuario(usuarioService.loginUsuario(idUsuario, pass));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("usuario", usuario);		
		
		return "inicio.jsf";
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
