package com.matesclass.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2349520471858712762L;

	@Id
	@Column(name = "ID_USUARIO")
	private String idUsuario;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String nombreLogro;

	@Column(name = "FH_ALTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhAlta;

	public Usuario() {

	}

	public Usuario(String idUsuario, String password, String nombreLogro,
			Date fhAlta) {
		this.idUsuario = idUsuario;
		this.password = password;
		this.nombreLogro = nombreLogro;
		this.fhAlta = fhAlta;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreLogro() {
		return nombreLogro;
	}

	public void setNombreLogro(String nombreLogro) {
		this.nombreLogro = nombreLogro;
	}

	public Date getFhAlta() {
		return fhAlta;
	}

	public void setFhAlta(Date fhAlta) {
		this.fhAlta = fhAlta;
	}
}
