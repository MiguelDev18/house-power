package com.migueldev.housepower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migueldev.housepower.model.RoleUsuario;


public interface RolesUsuarioRepository extends JpaRepository<RoleUsuario, Integer>{
	//verificar en si el usuario existe en la base de datos
	public boolean existsByUsername(String username);
}
