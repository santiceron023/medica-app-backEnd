package com.medicaapp.service;

import java.util.List;
import com.medicaapp.dto.ConsultaListaExamenDto;
import com.medicaapp.dto.ConsultaResumenDto;
import com.medicaapp.dto.FiltroConsultarDto;
import com.medicaapp.model.Consulta;

public interface IConsultaService{

	Consulta registrarTransaccional(ConsultaListaExamenDto dto);

	List<Consulta> buscar(FiltroConsultarDto filtro);
	List<Consulta> buscarFecha(FiltroConsultarDto filtro);
	List<ConsultaResumenDto> listarResumen();

	byte[] generarReporte();

	Consulta registrar(Consulta con);
	List<Consulta> listar();
	Consulta listarPorId(Integer id);
}
