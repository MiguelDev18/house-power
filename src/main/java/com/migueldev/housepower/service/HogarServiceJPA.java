package com.migueldev.housepower.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migueldev.housepower.model.Hogar;
import com.migueldev.housepower.repository.HogaresRepository;


@Service
public class HogarServiceJPA implements IHogarService{

	@Autowired
	private HogaresRepository hogaresRepo;
	
	@Override
	public List<Hogar> mostrarListaHogares() {
		
		return hogaresRepo.findAll();
	}

	@Override
	public List<Hogar> mostrarListaPorUsuario(int idUsuario) {
		
		return hogaresRepo.findByUsuario_IdOrderByIdDesc(idUsuario);
	}

	@Override
	public void guardarHogar(Hogar hogar) {
		//System.out.println("hogar (service):" + hogar);
		hogaresRepo.save(hogar);
		
	}

	@Override
	public void eliminarHogar(int idHogar) {
		hogaresRepo.deleteById(idHogar);		
	}

	@Override
	public Hogar mostrarHogar(int idHogar) {
		Optional<Hogar> hogar = hogaresRepo.findById(idHogar);
		if(hogar.isPresent())
			//verificar que se encuentre el hogar dentro de la base de datos
			return hogar.get();
		return null;
	}

	@Override
	public List<Hogar> mostrarListaPorUsername(String nombreUsuario) {
		
		return hogaresRepo.findByUsuario_UsernameOrderByIdDesc(nombreUsuario);
	}



}
