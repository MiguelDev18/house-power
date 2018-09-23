package com.migueldev.housepower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migueldev.housepower.model.Hogar;

public interface HogaresRepository extends JpaRepository<Hogar, Integer>{
	//select * from Hogares where idUsuarios = ? order by id desc
	public List<Hogar> findByUsuario_IdOrderByIdDesc(int idUsuario);
	
	public List<Hogar> findByUsuario_UsernameOrderByIdDesc(String userName);
	
	
}
