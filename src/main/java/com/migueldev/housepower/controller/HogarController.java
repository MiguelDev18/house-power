package com.migueldev.housepower.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.migueldev.housepower.model.Hogar;
import com.migueldev.housepower.model.Usuario;
import com.migueldev.housepower.service.IHogarService;
import com.migueldev.housepower.util.Response;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class HogarController {

	@Autowired
	private IHogarService hogarService;
	
	@RequestMapping(value = "/get_houses", method = RequestMethod.GET)
	public List<Hogar> mostrarHogares(){
		return hogarService.mostrarListaHogares();
	}
	
	@RequestMapping(value = "/get_house/{id}", method = RequestMethod.GET)
	public Hogar mostrarHogar(@PathVariable int id){
		return hogarService.mostrarHogar(id);
	}
	
	@RequestMapping(value = "/get_house_user", method = RequestMethod.POST)
	public List<Hogar> mostrarHogaresUsuario(@RequestBody Usuario usuario){
		return hogarService.mostrarListaPorUsername(usuario.getUsername());
	}
	
	@RequestMapping(value = "/save_house", method = RequestMethod.POST)
	public Response guardarHogar(@RequestBody Hogar hogar) {
		hogarService.guardarHogar(hogar);
		return new Response(HttpStatus.OK.value(), "Hogar guardado exitosamente");
	}
	
	@RequestMapping(value = "/delete_house", method = RequestMethod.POST)
	public Response eliminarHogar(@RequestBody Hogar hogar) {
		hogarService.eliminarHogar(hogar.getId());
		return new Response(HttpStatus.OK.value(), "Hogar borrado exitosamente");
	}
}
