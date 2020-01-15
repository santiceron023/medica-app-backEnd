package com.medicaapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.medicaapp.dto.ConsultaListaExamenDto;
import com.medicaapp.dto.ConsultaResumenDto;
import com.medicaapp.dto.FiltroConsultarDto;
import com.medicaapp.model.Consulta;

public interface IConsultaService{

	Consulta registrarTransaccional(ConsultaListaExamenDto dto);

	Page<Consulta> buscar(FiltroConsultarDto filtro);
	Page<Consulta> buscarFecha(FiltroConsultarDto filtro);
	List<ConsultaResumenDto> listarResumen();

	byte[] generarReporte();

	Consulta registrar(Consulta con);
	List<Consulta> listar();
	Consulta listarPorId(Integer id);

	Page<Consulta> listarPaginado(FiltroConsultarDto filtro);
}
