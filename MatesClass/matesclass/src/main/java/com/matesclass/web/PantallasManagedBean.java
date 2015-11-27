package com.matesclass.web;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.matesclass.business.LogroService;
import com.matesclass.business.PartidaService;
import com.matesclass.persistence.model.Partida;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "PantallasMB")
@ViewScoped
public class PantallasManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7597627229980681730L;

	private PartidaService partidaService = new PartidaService();
	private LogroService logroService = new LogroService();
	
	private Usuario usuario;
	private String idUsuario;

	private Partida partida;
	private Long idPartida;
	private Long puntos;
	private String seleccion;

	@PostConstruct
	public void init() {
		setUsuario(PlantillaManagedBean.usuario);
		setIdUsuario(usuario.getIdUsuario());

		setPartida((Partida) FacesContext.getCurrentInstance()
				.getExternalContext().getFlash().get("partida"));
		setIdPartida(partida.getIdPartida());
		setPuntos(partidaService.cargarPuntuacion(idPartida));
		
	}

	public void confirmar(String respuesta, String codProgreso) {
		if (respuesta.equals(seleccion)) {
			partidaService.cambiarPuntuacion(idPartida, 100L);
			setPuntos(partidaService.cargarPuntuacion(idPartida));
			partidaService.guardarProgreso(idPartida, progreso(codProgreso), codProgreso);
			String ruta = codProgreso + ".jsf?faces-redirect=true";
			if ('6'== codProgreso.charAt(2)){
				partidaService.guardarProgreso(idPartida, "Finalizada", codProgreso);
				String logro = String.valueOf(codProgreso.charAt(0));
				Long idLogro = Long.parseLong(logro);
				logroService.insertarLogro(idUsuario, idLogro);
			}
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.getFlash().put("partida", partida);
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(ruta);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			partidaService.cambiarPuntuacion(idPartida, -20L);
			setPuntos(partidaService.cargarPuntuacion(idPartida));
			error();
		}
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!",
						"Fallaste la respuesta"));
	}

	public String progreso (String codProgreso) {
		char curso = codProgreso.charAt(0);
		char nivel = codProgreso.charAt(2);
		String progreso = "Nivel " + nivel + " [" + curso + "º ESO]";
		return progreso;
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

	public PartidaService getPartidaService() {
		return partidaService;
	}

	public void setPartidaService(PartidaService partidaService) {
		this.partidaService = partidaService;
	}

	public Long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}

	public LogroService getLogroService() {
		return logroService;
	}

	public void setLogroService(LogroService logroService) {
		this.logroService = logroService;
	}

}
