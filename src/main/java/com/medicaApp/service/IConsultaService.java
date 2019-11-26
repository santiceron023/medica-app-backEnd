package com.medicaApp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.medicaApp.dto.ConsultaListaExamenDto;
import com.medicaApp.dto.ConsultaResumenDto;
import com.medicaApp.dto.FiltroConsultaDto;
import com.medicaApp.model.Consulta;


public interface IConsultaService extends ICRUD<Consulta> {

	Consulta registrarTransaccional(ConsultaListaExamenDto dto);
	
	List<Consulta> buscar(FiltroConsultaDto filtro);
	List<Consulta> buscarFecha(FiltroConsultaDto filtro);
	List<ConsultaResumenDto> listarExamen();

}
