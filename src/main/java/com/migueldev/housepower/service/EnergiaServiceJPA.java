package com.migueldev.housepower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migueldev.housepower.model.Energia;
import com.migueldev.housepower.repository.EnergiaRepository;


@Service
public class EnergiaServiceJPA implements IEnergiaService{
	
	@Autowired
	private EnergiaRepository energiaRepo;

	@Override
	public List<Energia> mostrarEnergiaHogar(int idHogar) {
		//encontrar la lista de consumo de energia correspondiente al hogar con el id solicitado
		return energiaRepo.findByHogar_IdOrderByDiaAsc(idHogar);
	}

	//guardar dato de consumo en la base de datos
	@Override
	public void insertarDato(Energia energia) {
		energiaRepo.save(energia);
		
	}

}
