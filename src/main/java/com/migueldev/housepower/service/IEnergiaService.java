package com.migueldev.housepower.service;

import java.util.List;

import com.migueldev.housepower.model.Energia;


public interface IEnergiaService {
	List<Energia> mostrarEnergiaHogar(int idHogar);
	void insertarDato(Energia energia);
}
