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
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.matesclass.persistence.dao.ILogroDAO;
import com.matesclass.persistence.model.Logro;

@ManagedBean(name = "LogroMB")
@ViewScoped
public class LogroManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682240388620079641L;

	// @Autowired
	// private ILogroDAO logroDAO;

	@ManagedProperty(value = "#{LogroDAO}")
	ILogroDAO logroDAO;

	@Resource(name = "jdbc/matesclass")
	private DataSource ds;

	List<Logro> listaLogro = new ArrayList<Logro>();
	Logro selectedLogro;

	@PostConstruct
	public void init() {
		// cargarListaLogros();
		try {
			consultaDB();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	// public void cargarListaLogros(){
	// try {
	// setListaLogroBean(consultaDB(con));
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// }
	// }

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

	public ILogroDAO getLogroDAO() {
		return logroDAO;
	}

	public void setLogroDAO(ILogroDAO logroDAO) {
		this.logroDAO = logroDAO;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void filaUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Logro unselect",
				((Logro) event.getObject()).getNombreLogro());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}
}
