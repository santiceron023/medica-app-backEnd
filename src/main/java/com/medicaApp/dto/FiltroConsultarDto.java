package com.medicaapp.dto;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class FiltroConsultarDto {

	private String documentId;
	private String nombreCompleto;
	@JsonSerialize(using = ToStringSerializer.class)
	@DateTimeFormat(iso = ISO.DATE)
	//    yyyy-MM-dd
	private LocalDate fechaConsulta;
	
	private PaginationRequestDto pagina;
	
	
	
	public FiltroConsultarDto() {
		this.pagina = new PaginationRequestDto();
	}
	
	public PaginationRequestDto getPagina() {
		return pagina;
	}
	public void setPagina(PaginationRequestDto pagina) {
		this.pagina = pagina;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void getDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDate getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDate fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}   


}
