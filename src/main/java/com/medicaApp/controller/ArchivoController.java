package com.medicaapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medicaapp.dto.ArchivoDto;
import com.medicaapp.model.Archivo;
import com.medicaapp.service.IArchivoService;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

	@Autowired
	IArchivoService servicio;


	@GetMapping("/imagen/{id}")
	@ResponseStatus(HttpStatus.OK)
	public byte[] leerImagenArrchivo(@PathVariable Integer id) {
		return this.servicio.leerArchivo(id);
	}
	
	@GetMapping("/lista")
	@ResponseStatus(HttpStatus.OK)
	public List<ArchivoDto> listarArchivos(){
		return this.servicio.listarArchivos();
	}


	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public int crear (@RequestParam("file") MultipartFile file) throws IOException{
		int rta=0;
		Archivo ar =  new Archivo();
		ar.setFilename(file.getOriginalFilename());
		ar.setValue(file.getBytes());
		ar.setFiletype(file.getContentType());
		rta = servicio.guardar(ar);
		return rta;
	}

}

