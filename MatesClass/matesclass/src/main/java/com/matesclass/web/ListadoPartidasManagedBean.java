package com.matesclass.web;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.matesclass.business.PartidaService;
import com.matesclass.persistence.model.Partida;
import com.matesclass.persistence.model.Usuario;

@ManagedBean(name = "ListaPartidasMB")
@ViewScoped
public class ListadoPartidasManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5769793819815453211L;
	
	private PartidaService partidaService = new PartidaService();

	private Usuario usuario;
	private String idUsuario;
	
	private ArrayList<Partida> listaPartidas = new ArrayList<Partida>();
	private Partida partida;
	
	@PostConstruct
	public void init() {
		setUsuario(PlantillaManagedBean.usuario);
		setIdUsuario(usuario.getIdUsuario());

		setListaPartidas((ArrayList<Partida>) partidaService.listarPartidas(idUsuario));
	}
	
	public String jugarPartida(){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("partida", partida);		
		
		char curso = partida.getCodProgreso().charAt(0);
		String ruta="pantallas/" + curso + "/" + partida.getCodProgreso() + ".jsf";
		
		return ruta;
	}
	
	public void eliminarPartida(){
		Long idPartida = partida.getIdPartida();
		partidaService.eliminarPartida(idPartida);
		setListaPartidas((ArrayList<Partida>) partidaService.listarPartidas(idUsuario));
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

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public ArrayList<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(ArrayList<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}
}
