package com.matesclass.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.matesclass.persistence.model.Partida;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "PantallasMB")
@ViewScoped
public class PantallasManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7597627229980681730L;

	
	private Usuario usuario;
	private String idUsuario;
	
	private Partida partida;
	private Long puntos;
	private String seleccion;
	
	@PostConstruct
	public void init() {
		setUsuario(PlantillaManagedBean.usuario);
		setIdUsuario(usuario.getIdUsuario());

		setPartida((Partida)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("partida"));
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

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Long getPuntos() {
		return puntos;
	}

	public void setPuntos(Long puntos) {
		this.puntos = puntos;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}
	
}
