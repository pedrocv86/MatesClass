package com.matesclass.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.matesclass.business.LogroService;
import com.matesclass.business.UsuarioService;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "InicioMB")
@ViewScoped
public class InicioManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1659773608442748770L;
	
	private LogroService logroService = new LogroService();
	private UsuarioService usuarioService = new UsuarioService();

	private Usuario usuario;
	private String idUsuario;


	@PostConstruct
	public void init() {
		setUsuario(PlantillaManagedBean.usuario);
		setIdUsuario(usuario.getIdUsuario());

	}


	public LogroService getLogroService() {
		return logroService;
	}


	public void setLogroService(LogroService logroService) {
		this.logroService = logroService;
	}


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	
}
