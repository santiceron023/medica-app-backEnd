package com.medicaApp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medicaApp.dao.IExamenDao;
import com.medicaApp.model.Examen;
import com.medicaApp.service.IExamenService;


@Service
public class ExamenServiceImpl implements IExamenService{

	
	@Autowired
	IExamenDao examenDao;
	 
	@Override
	public Examen registrar(Examen t) {		
		return examenDao.save(t);
	}

	@Override
	public Examen modificar(Examen t) {		
		return examenDao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		examenDao.delete(id);		
	}

	@Override
	public List<Examen> listar() {		
		return examenDao.findAll();
	}

	@Override
	public Examen listarPorId(Integer id) {		
		return examenDao.findOne(id);
	}

}
