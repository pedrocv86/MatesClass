package com.matesclass.web;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.matesclass.business.LogroService;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "PlantillaMB")
@SessionScoped
public class PlantillaManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4705784718014640720L;

	private LogroService logroService = new LogroService();
	
	static Usuario usuario;
	private String idUsuario;
	private boolean logro1 = false;
	private boolean logro2 = false;
	private boolean logro3 = false;
	private boolean logro4 = false;
	
	@PostConstruct
	public void init() {
		setUsuario((Usuario)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("usuario"));
		setIdUsuario(usuario.getIdUsuario());
		cargarLogros();
	}
	
	public void cargarLogros() {
		ArrayList<Long> listaLogros = logroService.listarLogros(idUsuario);
		for (Long logro : listaLogros) {
			if(logro==1L) setLogro1(true);
			if(logro==2L) setLogro2(true);
			if(logro==3L) setLogro3(true);
			if(logro==4L) setLogro4(true);
		}
		
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

	public LogroService getLogroService() {
		return logroService;
	}

	public void setLogroService(LogroService logroService) {
		this.logroService = logroService;
	}

	public boolean isLogro1() {
		return logro1;
	}

	public void setLogro1(boolean logro1) {
		this.logro1 = logro1;
	}

	public boolean isLogro2() {
		return logro2;
	}

	public void setLogro2(boolean logro2) {
		this.logro2 = logro2;
	}

	public boolean isLogro3() {
		return logro3;
	}

	public void setLogro3(boolean logro3) {
		this.logro3 = logro3;
	}

	public boolean isLogro4() {
		return logro4;
	}

	public void setLogro4(boolean logro4) {
		this.logro4 = logro4;
	}

}
