package com.medicaApp.service.impl;

import java.util.Optional;

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
		Optional<Archivo> opt = dao.findById(idArchivo);
		return opt.isPresent() ? opt.get().getValue() : new Archivo().getValue();
	}


}
