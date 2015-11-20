package com.matesclass.presentation.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.matesclass.business.LogroService;
import com.matesclass.business.UsuarioService;
import com.matesclass.persistence.model.Logro;

@ManagedBean(name = "LogroMB")
@ViewScoped
public class LogroManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682240388620079641L;


	LogroService logroService = new LogroService();
	UsuarioService usuarioService = new UsuarioService();

	List<Logro> listaLogro = new ArrayList<Logro>();
	Logro selectedLogro;
	
	String textoPantalla;

	@PostConstruct
	public void init() {
		
		//usuarioService.insertarUsuario();
		
		try {
			consultaDB();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//setTextoPantalla(logroService.probarCapas("Prueba de capas"));

	}


	public void consultaDB() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "MATESCLASS",
				"pcvmatesclass");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOGRO");

		while (rs.next()) {
			listaLogro.add(new Logro(Long.parseLong(rs
					.getString("ID_LOGRO")), rs.getString("NOMBRE_LOGRO")));
		}

		setListaLogroBean(listaLogro);
		con.close();
	}

	public List<Logro> getListaLogro() {
		return listaLogro;
	}

	public void setListaLogroBean(List<Logro> listaLogroBean) {
		this.listaLogro = listaLogroBean;
	}

	public Logro getSelectedLogro() {
		return selectedLogro;
	}

	public void setSelectedLogro(Logro selectedLogro) {
		this.selectedLogro = selectedLogro;
	}

	public void filaSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Logro select",
				((Logro) event.getObject()).getNombreLogro());
		FacesContext.getCurrentInstance().addMessage(null, msg);

		ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			ctx.redirect("nuevapartida.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void filaUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Logro unselect",
				((Logro) event.getObject()).getNombreLogro());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public String getTextoPantalla() {
		return textoPantalla;
	}

	public void setTextoPantalla(String textoPantalla) {
		this.textoPantalla = textoPantalla;
	}

	public void setListaLogro(List<Logro> listaLogro) {
		this.listaLogro = listaLogro;
	}
}
