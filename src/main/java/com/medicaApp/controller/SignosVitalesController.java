package com.medicaApp.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.medicaApp.model.SignosVitales;
import com.medicaApp.service.ISignosVitalesService;

@RestController
@RequestMapping("/signos")
public class SignosVitalesController {
	
	@Autowired
	private ISignosVitalesService service;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SignosVitales> listarTodos(){
		return service.listar();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void guardar(@RequestBody SignosVitales signos) {
		service.registrar(signos);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
	
	@GetMapping("/filtro")
	@ResponseStatus(HttpStatus.OK)
	public List<SignosVitales> filtro(
			@RequestParam(required = false) 
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate fecha,
			@RequestParam(required=false) Integer id,
			@RequestParam(required=false) String nombre){
		
		return service.filtro(fecha,id,nombre);
	}
	

}
