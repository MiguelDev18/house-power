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
	
	//retornar lista de hogares desde la base de datos
	@Override
	public List<Hogar> mostrarListaHogares() {
		
		return hogaresRepo.findAll();
	}

	//retornar lista de hogares correspondiente a idUsuario
	@Override
	public List<Hogar> mostrarListaPorUsuario(int idUsuario) {
		
		return hogaresRepo.findByUsuario_IdOrderByIdDesc(idUsuario);
	}

	//guardar hogar en la base de datos
	@Override
	public void guardarHogar(Hogar hogar) {
		
		hogaresRepo.save(hogar);
		
	}

	//eliminar hogar en la base de datos
	@Override
	public void eliminarHogar(int idHogar) {
		hogaresRepo.deleteById(idHogar);		
	}

	//si existe el hogar con id: idHogar, retornar el hogar
	@Override
	public Hogar mostrarHogar(int idHogar) {
		Optional<Hogar> hogar = hogaresRepo.findById(idHogar);
		if(hogar.isPresent())
			//verificar que se encuentre el hogar dentro de la base de datos
			return hogar.get();
		return null;
	}

	//mostrar lista de hogares del usuario: nombreUsuario
	@Override
	public List<Hogar> mostrarListaPorUsername(String nombreUsuario) {
		
		return hogaresRepo.findByUsuario_UsernameOrderByIdDesc(nombreUsuario);
	}



}
