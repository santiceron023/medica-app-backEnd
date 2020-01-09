package com.medicaApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medicaApp.dao.IConsultaExamenDao;
import com.medicaApp.model.ConsultaExamen;
import com.medicaApp.service.IConsultaExamenService;
	
public class ConsultaExamenExamenServiceImpl implements IConsultaExamenService {
	
	@Autowired
	private IConsultaExamenDao dao;

	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return dao.listarExamenesPorConsulta(idconsulta);
	}

}
