package com.matesclass.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.matesclass.business.PartidaService;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "NuevaPartidaMB")
@ViewScoped
public class NuevaPartidaManagedBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8965148642322580604L;

	private PartidaService partidaService = new PartidaService();
	
	private Usuario usuario;
	private String idUsuario;
	private String nombrePartida;
	private String progreso;
	private String codProgreso;
	
	
	@PostConstruct
	public void init() {
		setUsuario(PlantillaManagedBean.usuario);
		setIdUsuario(usuario.getIdUsuario());

	}

	public void elegirCategoria(String progreso, String codProgreso){
		setProgreso(progreso);
		setCodProgreso(codProgreso);
	}
	
	public String asignarNombrePartida(){
		char curso = codProgreso.charAt(0);
		String pantalla = "pantallas/" + curso + "/" + codProgreso + ".jsf";
		
		partidaService.crearPartida(nombrePartida, idUsuario, progreso, codProgreso);
		
		return pantalla;
	}
	
	public PartidaService getPartidaService() {
		return partidaService;
	}

	public void setPartidaService(PartidaService partidaService) {
		this.partidaService = partidaService;
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

	public String getNombrePartida() {
		return nombrePartida;
	}

	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}

	public String getProgreso() {
		return progreso;
	}

	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}

	public String getCodProgreso() {
		return codProgreso;
	}

	public void setCodProgreso(String codProgreso) {
		this.codProgreso = codProgreso;
	}
	
}
