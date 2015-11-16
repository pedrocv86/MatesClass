package com.matesclass.presentation.beans;

import java.io.Serializable;

public class LogroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9078014229630781288L;
	
	
	private Long idLogro;
	private String nombreLogro;

	public LogroBean() {
	}

	public LogroBean(Long idLogro, String nombreLogro) {
		this.setIdLogro(idLogro);
		this.setNombreLogro(nombreLogro);
	}

	public Long getIdLogro() {
		return idLogro;
	}

	public void setIdLogro(Long idLogro) {
		this.idLogro = idLogro;
	}

	public String getNombreLogro() {
		return nombreLogro;
	}

	public void setNombreLogro(String nombreLogro) {
		this.nombreLogro = nombreLogro;
	}

}
