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
	
	@Override
	public List<Usuario> mostrarListaUsuarios() {
		System.out.println(usuariosRepo.findAll());
		return usuariosRepo.findAll();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuariosRepo.save(usuario);
		
	}

	@Override
	public Usuario mostrarUsuario(int idUsuario) {
		Optional<Usuario> usuario = usuariosRepo.findById(idUsuario);
		if(usuario.isPresent())
			return usuario.get();
		return null;
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);
		
	}

	@Override
	public Usuario mostrarUsuario(String username) {
		
		return usuariosRepo.findByUsername(username);
	}

}