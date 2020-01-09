package com.medicaapp.controller;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medicaapp.exceptions.ModeloNotFoundException;
import com.medicaapp.model.Examen;
import com.medicaapp.service.IExamenService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	IExamenService servicio;

	@GetMapping
	public ResponseEntity<List<Examen>> listar(){		
		return new ResponseEntity< List<Examen> >(servicio.listar(),HttpStatus.OK);
	}

	//	hateoas --> la respuesta trae info de acceso a recursos,
	//	en este caso será la url consultada
@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Examen> listarPorId(@PathVariable("id") Integer id){

		Examen exaSaved = servicio.listarPorId(id);

		if (exaSaved == null) {
			//mi error creado
			throw new ModeloNotFoundException("Id no encontrado : " + id);
		}

		Resource<Examen> resource = new Resource<>(exaSaved);
		//  /Examenes/{id}   <- va a ese recurso y le pone el id
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		//agregar el link al recurso
		resource.add(linkTo.withRel("Examen-resource"));
		//https://www.adictosaltrabajo.com/2013/12/02/spring-hateoas/

		return resource;
	}

	@PostMapping
	public ResponseEntity<Examen> registrar(@Valid @RequestBody Examen exa) {

		Examen exaSaved = servicio.registrar(exa);
		//devolver id
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(exaSaved.getIdExamen()).toUri();

		return ResponseEntity.created(uriLocation).build();
	}


	@DeleteMapping(value = "/{id}")
	public void eliminarPorId(@PathVariable("id") Integer id){

		if(servicio.listarPorId(id) != null) {
			servicio.eliminar(id);
		}else {
			throw new ModeloNotFoundException("ïs no encontrado : " + id);
		}
	}


	@PutMapping
	public Examen modificar(@RequestBody Examen exa) {
		return servicio.modificar(exa);
	}

}
