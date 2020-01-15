package com.medicaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medicaapp.dto.FiltroConsultarDto;
import com.medicaapp.dto.PaginationRequestDto;
import com.medicaapp.model.SignosVitales;
import com.medicaapp.service.ISignosVitalesService;

@RestController
@RequestMapping("/signos")
public class SignosVitalesController {

	@Autowired
	private ISignosVitalesService service;


	@PostMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public Page<SignosVitales> listarTodos(@RequestBody PaginationRequestDto pageReq){
		return service.listarTodoPaginado(pageReq);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void guardar(@RequestBody SignosVitales signos) {
		service.registrar(signos);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody SignosVitales signos) {
		service.registrar(signos);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}

	@PostMapping("/filtro")
	@ResponseStatus(HttpStatus.OK)
	public Page<SignosVitales> filtro(
			@RequestBody(required = false) FiltroConsultarDto filtro){
		if(filtro == null) {
			filtro = new FiltroConsultarDto();
		}
		return service.filtroPaginado(filtro.getFechaConsulta(),
				filtro.getDocumentId(),
				filtro.getNombreCompleto(),
				filtro.getPagina());
	}


}
