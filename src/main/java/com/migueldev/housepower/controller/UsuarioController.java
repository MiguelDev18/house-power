package com.migueldev.housepower.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.migueldev.housepower.model.Usuario;
import com.migueldev.housepower.service.IUsuarioService;
import com.migueldev.housepower.util.Response;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@RequestMapping(value = "/get_users", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> mostrarUsuarios(){
		
		return serviceUsuario.mostrarListaUsuarios();
	}
	
	@RequestMapping(value = "/save_user", method = RequestMethod.POST)
	public Response guardarUsuario(@RequestBody Usuario usuario) {
		serviceUsuario.guardarUsuario(usuario);
		
		return new Response(HttpStatus.OK.value(), "Usuario guardado exitosamente");
		
	}
	
	@RequestMapping(value = "/delete_user", method = RequestMethod.POST)
	public Response borrarUsuario(@RequestBody Usuario usuario) {
		serviceUsuario.eliminarUsuario(usuario.getId());
		return new Response(HttpStatus.OK.value(), "Usuario borrado exitosamente");
	}
	
}
