package com.medicaapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medicaapp.dto.ConsultaDto;
import com.medicaapp.dto.ConsultaListaExamenDto;
import com.medicaapp.dto.ConsultaResumenDto;
import com.medicaapp.dto.FiltroConsultarDto;
import com.medicaapp.model.Consulta;
import com.medicaapp.model.Paciente;
import com.medicaapp.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	IConsultaService servicio;

	@PostMapping
	public ResponseEntity<Paciente> registrar(@RequestBody ConsultaListaExamenDto cons) {

		Consulta conSaved = servicio.registrarTransaccional(cons);

		//id created info
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(conSaved.getIdConsulta()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}



	@PostMapping(value = "/listaExamen")
	public ResponseEntity<Paciente> registrarListaExamen(@RequestBody Consulta cons) {

		Consulta conSaved = servicio.registrar(cons);

		//id created info
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(conSaved.getIdConsulta()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}

	@GetMapping(value="/hateoas")
	public ResponseEntity<List<ConsultaDto>> listarHateoas() {
		List<ConsultaDto> consultasDto = new ArrayList<>();
		List<Consulta> consultas = servicio.listar();

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
			
			// nombre del campo link
			dto.add(linkTo2.withRel("medico-url"));

			ControllerLinkBuilder linkTo3 = 
					linkTo(methodOn(PacienteController.class).listarPorId(dto.getPac()
							.getIdPaciente()) );
			dto.add(linkTo3.withSelfRel());
			
			consultasDto.add(dto);
		}

		return new ResponseEntity<List<ConsultaDto>>(consultasDto, HttpStatus.OK);

	}


	@GetMapping(value="/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable int id) {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}

	@PostMapping(value = "buscar")
	public ResponseEntity<Page<Consulta>>filtroBuscar(@RequestBody FiltroConsultarDto filtro){
		Page<Consulta> consultas = null;
		if(filtro.getFechaConsulta() == null && filtro.getNombreCompleto() == null ) {
			consultas = servicio.listarPaginado(filtro);
		}else if( filtro.getFechaConsulta() != null) {
			consultas = servicio.buscarFecha(filtro);
		}else if( filtro.getNombreCompleto() != null) {
			consultas = servicio.buscar(filtro);
		}
		return new ResponseEntity<>(consultas,HttpStatus.OK);

	}

	@GetMapping(value="/listarResumen")
	public ResponseEntity<List<ConsultaResumenDto>> listarResumen() {
		return new ResponseEntity<>(servicio.listarResumen(), HttpStatus.OK);
	}


	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public byte[] generarReporte() {
		byte[] data = null;
		data= servicio.generarReporte();
		return data;
	}
	
	
}




