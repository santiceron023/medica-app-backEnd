package com.medicaapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;

import com.medicaapp.dto.PaginationRequestDto;
import com.medicaapp.model.SignosVitales;

public interface ISignosVitalesService extends ICRUD<SignosVitales>{

	Page<SignosVitales> filtroPaginado(LocalDate fecha, String id, String nombre, PaginationRequestDto paginationReq);

	Page<SignosVitales> listarTodoPaginado(PaginationRequestDto pageReq);

}
