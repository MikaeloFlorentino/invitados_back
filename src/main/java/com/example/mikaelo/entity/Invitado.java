package com.example.mikaelo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invitados")
public class Invitado {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	@Column(name="invitado_de")
	private String invitadoDe;
	
	private String grupo; 	
	
	@Column(name="nombre_completo")
	private String nombreCompleto;
	
	private Integer mesa;
	
	@Column(name="numero_invitados")
	private Integer numeroInvitado;
	
	private boolean viaje;
	
	private String mensaje;
	
	@Column(name="confirma_asistencia")
	private boolean confirmaAsistencia;
	
	@Column(name="fecha_confimacion")
	private Date fechaConfimacion;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInvitadoDe() {
		return invitadoDe;
	}

	public void setInvitadoDe(String invitadoDe) {
		this.invitadoDe = invitadoDe;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getMesa() {
		return mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}

	public Integer getNumeroInvitado() {
		return numeroInvitado;
	}

	public void setNumeroInvitado(Integer numeroInvitado) {
		this.numeroInvitado = numeroInvitado;
	}

	public boolean isViaje() {
		return viaje;
	}

	public void setViaje(boolean viaje) {
		this.viaje = viaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isConfirmaAsistencia() {
		return confirmaAsistencia;
	}

	public void setConfirmaAsistencia(boolean confirmaAsistencia) {
		this.confirmaAsistencia = confirmaAsistencia;
	}

	public Date getFechaConfimacion() {
		return fechaConfimacion;
	}

	public void setFechaConfimacion(Date fechaConfimacion) {
		this.fechaConfimacion = fechaConfimacion;
	}
	
}
