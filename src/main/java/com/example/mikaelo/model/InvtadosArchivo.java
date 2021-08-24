package com.example.mikaelo.model;

public class InvtadosArchivo {

	private String nombre;
	private String grupo;
	private Integer numero;
	private Integer mesa;
	private String nombreCompleto;
	private String invitadoDe;
	private boolean viaja;
	private String mensaje;
	
	public InvtadosArchivo() {
		
	}
	
	public InvtadosArchivo(String nombre, String grupo, Integer numero, Integer mesa, String nombreCompleto,
			String invitadoDe, boolean viaja, String mensaje) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
		this.numero = numero;
		this.mesa = mesa;
		this.nombreCompleto = nombreCompleto;
		this.invitadoDe = invitadoDe;
		this.viaja = viaja;
		this.mensaje = mensaje;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getMesa() {
		return mesa;
	}
	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getInvitadoDe() {
		return invitadoDe;
	}
	public void setInvitadoDe(String invitadoDe) {
		this.invitadoDe = invitadoDe;
	}
	public boolean isViaja() {
		return viaja;
	}
	public void setViaja(boolean viaja) {
		this.viaja = viaja;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
