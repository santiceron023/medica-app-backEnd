package com.medicaApp.dto;

import java.util.List;

import com.medicaApp.model.Consulta;
import com.medicaApp.model.Examen;

public class ConsultaListaExamenDto {

	private Consulta consulta;
	private List<Examen> examenList;
	
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public List<Examen> getExamenList() {
		return examenList;
	}
	public void setExamenList(List<Examen> examenList) {
		this.examenList = examenList;
	}
	
	
	
	
}
