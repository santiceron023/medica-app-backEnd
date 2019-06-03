package com.medicaApp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medicaApp.dto.ConsultaListaExamenDto;
import com.medicaApp.model.Consulta;
import com.medicaApp.model.Paciente;
import com.medicaApp.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	IConsultaService servicio;

	//@PostMapping
	//un solo Json
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Paciente> registrar(@RequestBody ConsultaListaExamenDto cons) {

		Consulta conSaved = servicio.registrarTransaccional(cons);

		//id creado
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(conSaved.getIdConsulta()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}



	//	@PostMapping
	@RequestMapping(value = "/listaExamen",method = RequestMethod.POST)
	public ResponseEntity<Paciente> registrarListaExamen(@RequestBody Consulta cons) {

		Consulta conSaved = servicio.registrar(cons);

		//id creado
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(conSaved.getIdConsulta()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getConsultas() {

		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);

	}




}
