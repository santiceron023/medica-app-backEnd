package com.medicaapp.service.impl;

import java.time.LocalDate;
import com.medicaapp.util.ParserUtils;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaapp.dao.ISignosVitalesDao;
import com.medicaapp.model.SignosVitales;
import com.medicaapp.service.ISignosVitalesService;


@Service
public class SignosVitalesServiceImpl implements ISignosVitalesService{

	@Autowired
	private ISignosVitalesDao dao;

	@Override
	public SignosVitales registrar(SignosVitales t) {
		return dao.save(t);
	}

	@Override
	public SignosVitales modificar(SignosVitales t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);		
	}

	//no used
	@Override
	public List<SignosVitales> listar() {
		return this.filtro(null,null,null);
	}

	@Override
	public SignosVitales listarPorId(Integer id) {
		Optional<SignosVitales> element = dao.findById(id);
		return element.isPresent() ? element.get() : new SignosVitales();

	}

	@Override
	public List<SignosVitales> filtro(LocalDate fecha, String id, String nombre) {
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
}
