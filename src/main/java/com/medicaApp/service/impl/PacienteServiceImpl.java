package com.medicaApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medicaApp.dao.IConsultaExamenDao;
import com.medicaApp.dao.IPacienteDao;
import com.medicaApp.model.Paciente;
import com.medicaApp.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{


	@Autowired
	IPacienteDao pacienteDao;
	
	@Autowired
	IConsultaExamenDao con;

	@Override
	public Paciente registrar(Paciente t) {
		return pacienteDao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		return pacienteDao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		pacienteDao.delete(id);

	}

	@Override
	public List<Paciente> listar() {
		return pacienteDao.findAll();
	}

	@Override
	public Paciente listarPorId(Integer id) {
		return pacienteDao.findOne(id);
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {
		return pacienteDao.findAll(pageable);
	}

}
