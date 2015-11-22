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
	private String email;

	@Column(name = "FH_ALTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhAlta;

	public Usuario() {

	}

	public Usuario(String idUsuario, String password, String email,
			Date fhAlta) {
		this.idUsuario = idUsuario;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFhAlta() {
		return fhAlta;
	}

	public void setFhAlta(Date fhAlta) {
		this.fhAlta = fhAlta;
	}
}
