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

import com.migueldev.housepower.model.Energia;
import com.migueldev.housepower.service.IEnergiaService;
import com.migueldev.housepower.util.Response;

@CrossOrigin(origins= {"*"})
@RestController
public class EnergiaController {
	
	@Autowired
	private IEnergiaService enegiaService;
	
	@RequestMapping(value = "/record_energy", method = RequestMethod.POST)
	public Response registrarConsumo(@RequestBody Energia energia) {
		enegiaService.insertarDato(energia);
		return new Response(HttpStatus.OK.value(), "dato registrado exitosamente");
	}
	
	@RequestMapping(value = "/get_data/{idHogar}", method = RequestMethod.GET)
	public List<Energia> mostrarDatosEnergia(@PathVariable int idHogar){
		return enegiaService.mostrarEnergiaHogar(idHogar);
	}

}
