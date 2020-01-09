package com.medicaapp.service;

import java.util.List;
import com.medicaapp.dto.ConsultaListaExamenDto;
import com.medicaapp.dto.ConsultaResumenDto;
import com.medicaapp.dto.FiltroConsultaDto;
import com.medicaapp.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta> {

	Consulta registrarTransaccional(ConsultaListaExamenDto dto);
	
	List<Consulta> buscar(FiltroConsultaDto filtro);
	List<Consulta> buscarFecha(FiltroConsultaDto filtro);
	List<ConsultaResumenDto> listarResumen();

	byte[] generarReporte();
}
