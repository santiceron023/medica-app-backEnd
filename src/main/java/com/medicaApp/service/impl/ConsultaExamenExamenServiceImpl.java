package com.medicaapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medicaapp.dao.IConsultaExamenDao;
import com.medicaapp.model.ConsultaExamen;
import com.medicaapp.service.IConsultaExamenService;
	
public class ConsultaExamenExamenServiceImpl implements IConsultaExamenService {
	
	@Autowired
	private IConsultaExamenDao dao;

	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return dao.listarExamenesPorConsulta(idconsulta);
	}

}
