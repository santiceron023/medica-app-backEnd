package com.medicaapp.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medicaapp.dao.ISignosVitalesDao;
import com.medicaapp.dto.PaginationRequestDto;
import com.medicaapp.model.SignosVitales;
import com.medicaapp.service.ISignosVitalesService;
import com.medicaapp.util.ParserUtils;


@Service
public class SignosVitalesServiceImpl implements ISignosVitalesService{

	@Autowired
	private ISignosVitalesDao dao;

	@Override
	public SignosVitales registrar(SignosVitales t) {
		t.setFecha( LocalDateTime.of(
				t.getFecha().toLocalDate(),LocalTime.now()
				));
		return dao.save(t);
	}

	@Override
	public SignosVitales modificar(SignosVitales t) {
		return this.registrar(t);
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);		
	}


	@Override
	public Page<SignosVitales> listarTodoPaginado(PaginationRequestDto pageReq) {
		return this.filtroPaginado(null,null,null,pageReq);
	}

	@Override
	public SignosVitales listarPorId(Integer id) {
		Optional<SignosVitales> element = dao.findById(id);
		return element.isPresent() ? element.get() : new SignosVitales();

	}

	@Override
	public Page<SignosVitales> filtroPaginado(LocalDate fecha, String id, String nombre, PaginationRequestDto pageReq) {
		List<SignosVitales> lista = filtro(fecha, id, nombre);

		Pageable pageable = PageRequest.of(pageReq.getPagina(), pageReq.getTamano());

		int start = (int) pageable.getOffset();
		int end = (start + pageable.getPageSize()) > lista.size() ? lista.size() : (start + pageable.getPageSize());
		return new PageImpl<SignosVitales>(lista.subList(start, end), pageable, lista.size());

	}

	private List<SignosVitales> filtro(LocalDate fecha, String id, String nombre) {
		LocalDateTime fechaFin = null;
		LocalDateTime fechaInicio = null;
		if(fecha != null) {
			fechaFin = LocalDateTime.of(fecha, LocalTime.MAX);
			fechaInicio = LocalDateTime.of(fecha, LocalTime.MIN);	
		}
		id = ParserUtils.checkEmpty(id);
		nombre = ParserUtils.checkEmpty(nombre);

		return dao.filtro(fechaInicio,fechaFin,id,nombre);
	}

	@Override
	public List<SignosVitales> listar() {
		return filtro(null,null,null);
	}
}
