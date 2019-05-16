package com.medicaApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//adiciona cod respuesta
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {

	public ModeloNotFoundException(String mensaje){
		//para mensaje de exception
		super(mensaje);
	}
	
}
