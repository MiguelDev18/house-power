package com.migueldev.housepower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migueldev.housepower.model.Energia;



public interface EnergiaRepository extends JpaRepository<Energia, Integer>{
	public List<Energia> findByHogar_IdOrderByDiaAsc(int idHogar);
}
