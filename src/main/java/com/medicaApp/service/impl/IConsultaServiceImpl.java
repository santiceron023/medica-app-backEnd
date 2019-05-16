package com.medicaApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaApp.dao.IConsultaDao;
import com.medicaApp.model.Consulta;
import com.medicaApp.service.IConsultaService;

@Service
public class IConsultaServiceImpl implements IConsultaService {

	
	@Autowired
	IConsultaDao dao;
	
	@Override
	public Consulta registrar(Consulta con) {
		con.getDetalleConsulta().forEach(detalle -> detalle.setConsulta(con) );
		return dao.save(con);
	}

	@Override
	public Consulta modificar(Consulta t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
