package com.migueldev.housepower.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Hogares")
public class Hogar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String direccion;
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name = "idUsuarios")
	private Usuario usuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Hogar [id=" + id + ", direccion=" + direccion + ", ciudad=" + ciudad + ", usuario=" + usuario + "]";
	}
	
	
	
}
