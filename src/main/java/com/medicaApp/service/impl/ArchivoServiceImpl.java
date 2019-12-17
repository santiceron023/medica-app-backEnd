package com.medicaApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaApp.dao.IArchivoDao;
import com.medicaApp.model.Archivo;
import com.medicaApp.service.IArchivoService;

@Service
public class ArchivoServiceImpl implements IArchivoService{

	@Autowired
	private IArchivoDao dao;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = dao.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		return dao.findOne(idArchivo).getValue();
	}


}
