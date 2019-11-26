package com.medicaApp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medicaApp.dto.ConsultaDto;
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

	@RequestMapping(method = RequestMethod.GET,value="/hateoas")
	public ResponseEntity<List<ConsultaDto>> listarHateoas() {
		List<ConsultaDto> consultasDto = new ArrayList<>();
		List<Consulta> consultas = new ArrayList<>();
		consultas = servicio.listar();

		for (Consulta consulta : consultas) {
			ConsultaDto dto =  new ConsultaDto();
			dto.setIdConsulta(consulta.getIdConsulta());
			dto.setMedico(consulta.getMedico());
			dto.setPac(consulta.getPaciente());


			ControllerLinkBuilder linkTo = 
					linkTo(methodOn(this.getClass()).listarPorId(dto.getIdConsulta()) );
			dto.add(linkTo.withSelfRel());

			ControllerLinkBuilder linkTo2 = 
					linkTo(methodOn(MedicoController.class).listarPorId(dto.getMedico()
							.getIdMedico()) );
			//nombre del campo link
			dto.add(linkTo2.withRel("medico-url"));
//			consultasDto.add(dto);

			ControllerLinkBuilder linkTo3 = 
					linkTo(methodOn(PacienteController.class).listarPorId(dto.getPac()
							.getIdPaciente()) );
			dto.add(linkTo3.withSelfRel());
			consultasDto.add(dto);
		}
		
		return new ResponseEntity<List<ConsultaDto>>(consultasDto, HttpStatus.OK);

	}


	@RequestMapping(method = RequestMethod.GET,value="/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable int id) {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}




}
