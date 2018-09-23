package com.migueldev.housepower.service;

import java.util.List;

import com.migueldev.housepower.model.Hogar;


public interface IHogarService {
	List<Hogar> mostrarListaHogares();
	List<Hogar> mostrarListaPorUsuario(int idUsuario);
	List<Hogar> mostrarListaPorUsername(String nombreUsuario);
	void guardarHogar(Hogar hogar);
	void eliminarHogar(int idHogar);
	Hogar mostrarHogar(int idHogar);
	
}
