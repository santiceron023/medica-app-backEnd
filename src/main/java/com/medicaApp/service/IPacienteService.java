package com.medicaApp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.medicaApp.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente> {

	Page<Paciente> listarPageable(Pageable pageable);
	
}
