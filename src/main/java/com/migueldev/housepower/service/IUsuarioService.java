package com.migueldev.housepower.service;

import java.util.List;

import com.migueldev.housepower.model.Usuario;




public interface IUsuarioService {

	List<Usuario> mostrarListaUsuarios();
	void guardarUsuario(Usuario usuario);
	//void guardarRole(RoleUsuario role);
	//boolean existeRole(String username);
	Usuario mostrarUsuario(int idUsuario);
	void eliminarUsuario(int idUsuario);
	Usuario mostrarUsuario(String username);
}
