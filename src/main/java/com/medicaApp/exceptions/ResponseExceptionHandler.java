package com.medicaApp.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController 
//para que sepna que ella es trnasversal 
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{


	//para clase de error que cree
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExcepciones(ModeloNotFoundException ex, WebRequest request){

		//clase que hice
		ExceptionResponse excepResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(excepResp, HttpStatus.NOT_FOUND);
	}
	
	
	
	//para todas las excepciones
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request){

		//clase que hice
		ExceptionResponse excepResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(excepResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	


	//no funciona ---> necesitaba el valid para comprobar el constrain
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		//obtener tdos los erroes
		String errores = "";
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errores +=  error.getDefaultMessage()+ ";";
		}
		//clase que hice
		ExceptionResponse excepResp = new ExceptionResponse(new Date(),"validacion fallida", errores);
		return new ResponseEntity(excepResp, HttpStatus.BAD_REQUEST);
	}



}
