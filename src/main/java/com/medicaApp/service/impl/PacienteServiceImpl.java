package com.medicaApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaApp.dao.IPacienteDao;
import com.medicaApp.model.Paciente;
import com.medicaApp.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	
	@Autowired
	IPacienteDao pacienteDao;
	
	@Override
	public Paciente registrar(Paciente t) {
		// TODO Auto-generated method stub
		return pacienteDao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		// TODO Auto-generated method stub
		return pacienteDao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		pacienteDao.delete(id);
		
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return pacienteDao.findAll();
	}

	@Override
	public Paciente listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return pacienteDao.findOne(id);
	}

}
