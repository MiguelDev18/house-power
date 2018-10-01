package com.migueldev.housepower.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migueldev.housepower.model.Usuario;
import com.migueldev.housepower.repository.UsuariosRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	//retornar lista de usuarios desde la base de datos
	@Override
	public List<Usuario> mostrarListaUsuarios() {
		return usuariosRepo.findAll();
	}

	//guardar hogar en la base de datos
	@Override
	public void guardarUsuario(Usuario usuario) {
		usuariosRepo.save(usuario);
		
	}

	//si existe el usuario con id: idUsuario, devuelve el usuario de lo contrario retorna null
	@Override
	public Usuario mostrarUsuario(int idUsuario) {
		Optional<Usuario> usuario = usuariosRepo.findById(idUsuario);
		if(usuario.isPresent())
			return usuario.get();
		return null;
	}

	//eliminar usuario en la base de datos
	@Override
	public void eliminarUsuario(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);
		
	}

	//devolver el usuario de acuerdo a su username
	@Override
	public Usuario mostrarUsuario(String username) {
		
		return usuariosRepo.findByUsername(username);
	}

}