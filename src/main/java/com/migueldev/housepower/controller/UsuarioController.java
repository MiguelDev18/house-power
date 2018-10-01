package com.migueldev.housepower.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.migueldev.housepower.model.Usuario;
import com.migueldev.housepower.service.IUsuarioService;
import com.migueldev.housepower.util.Response;

//Configuracion CORS origen de peticiones aceptadas
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	//enviar la lista de usuarios 
	@RequestMapping(value = "/get_users", method = RequestMethod.GET)
	public List<Usuario> mostrarUsuarios(){
		return usuarioService.mostrarListaUsuarios();
	}
	
	//guardar el usuario en el servidor
	@RequestMapping(value = "/save_user", method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.CREATED)
	public Response guardarUsuario(@RequestBody Usuario usuario) {
		usuarioService.guardarUsuario(usuario);
		//retornar mensaje de exito
		return new Response(HttpStatus.OK.value(), "El Usuario " + usuario.getUsername() + " ha sido guardado exitosamente");
		
	}
	
	//borrar el usuario de acuerdo al id de la peticion
	@RequestMapping(value = "/delete_user", method = RequestMethod.POST)
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public Response borrarUsuario(@RequestBody Usuario usuario) {
		String username = usuarioService.mostrarUsuario(usuario.getId()).getUsername();
		usuarioService.eliminarUsuario(usuario.getId());
		//retornar mensaje de exito
		return new Response(HttpStatus.OK.value(), "El Usuario " + username + " ha sido borrado exitosamente");
	}
	
}
