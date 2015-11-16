package com.matesclass.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PARTIDA")
public class Partida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5700382842996854275L;

	@Id
	@SequenceGenerator(name = "PARTIDA_IDPARTIDA_PARTIDA", sequenceName = "PARTIDA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTIDA_IDPARTIDA_PARTIDA")
	@Column(name = "ID_PARTIDA")
	private Long idPartida;

	@Column(name = "NOMBRE_PARTIDA")
	private String nombrePartida;

	@Column(name = "FH_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fhCreacion;

	@Column(name = "PUNTUACION")
	private Long puntuacion;

	@Column(name = "PROGRESO")
	private String progreso;

	@Column(name = "ID_USARIO")
	private String idUsuario;

	public Partida() {

	}

	public Partida(Long idPartida, String nombrePartida, Date fhCreacion,
			Long puntuacion, String progreso, String idUsuario) {
		this.idPartida = idPartida;
		this.nombrePartida = nombrePartida;
		this.fhCreacion = fhCreacion;
		this.puntuacion = puntuacion;
		this.progreso = progreso;
		this.idUsuario = idUsuario;
	}

	public Long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}

	public String getNombrePartida() {
		return nombrePartida;
	}

	public void setNombrePartida(String nombrePartida) {
		this.nombrePartida = nombrePartida;
	}

	public Date getFhCreacion() {
		return fhCreacion;
	}

	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	public Long getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Long puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getProgreso() {
		return progreso;
	}

	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}
