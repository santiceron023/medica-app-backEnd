package com.medicaApp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping
	//un solo Json
	public ResponseEntity<Paciente> registrar(@RequestBody ConsultaListaExamenDto cons) {
		//	public ResponseEntity<Paciente> registrar(@RequestBody Consulta cons) {

		Consulta conSaved = servicio.registrarTransaccional(cons);
		//		Consulta conSaved = servicio.registrar(cons);

		//original + id 
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(conSaved.getIdConsulta()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}


}
