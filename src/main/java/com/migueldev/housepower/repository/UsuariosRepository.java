package com.migueldev.housepower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migueldev.housepower.model.Usuario;


public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByUsername(String username);

}
