package com.medicaApp.dto;

import org.springframework.hateoas.ResourceSupport;

import com.medicaApp.model.Medico;
import com.medicaApp.model.Paciente;

public class ConsultaDto extends ResourceSupport {

	private int idConsulta;
	private Medico medico;
	private Paciente pac;
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPac() {
		return pac;
	}
	public void setPac(Paciente pac) {
		this.pac = pac;
	}
	
	
	
}
