package com.matesclass.presentation.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.matesclass.persistence.dao.ILogroDAO;
import com.matesclass.persistence.dao.LogroDAO;
import com.matesclass.presentation.beans.LogroBean;

@ManagedBean(name = "LogroMB")
@ViewScoped
public class LogroManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2682240388620079641L;

	//@Autowired
	//private ILogroDAO logroDAO;
	ILogroDAO logroDAO = new LogroDAO();
	
	List<LogroBean> listaLogroBean = new ArrayList<LogroBean>();


	@PostConstruct
	public void init() {
		cargarListaLogros();
		
	}
	
	public void cargarListaLogros(){
		setListaLogroBean(logroDAO.mostrarLogros());
	}
	
	public ILogroDAO getLogroDAO() {
		return logroDAO;
	}

	public void setLogroDAO(ILogroDAO logroDAO) {
		this.logroDAO = logroDAO;
	}

	public List<LogroBean> getListaLogroBean() {
		return listaLogroBean;
	}

	public void setListaLogroBean(List<LogroBean> listaLogroBean) {
		this.listaLogroBean = listaLogroBean;
	}
	
}

