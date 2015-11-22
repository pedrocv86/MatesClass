package com.matesclass.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "PlantillaMB")
@SessionScoped
public class PlantillaManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4705784718014640720L;

	static Usuario usuario;
	private String idUsuario;
	
	
	@PostConstruct
	public void init() {
		setUsuario((Usuario)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("usuario"));
		setIdUsuario(usuario.getIdUsuario());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		PlantillaManagedBean.usuario = usuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
}
