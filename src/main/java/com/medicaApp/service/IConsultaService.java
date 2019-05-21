package com.medicaApp.service;

import com.medicaApp.dto.ConsultaListaExamenDto;
import com.medicaApp.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta> {
	
	Consulta registrarTransaccional(ConsultaListaExamenDto dto);

}
