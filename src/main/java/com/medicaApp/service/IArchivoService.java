package com.medicaapp.service;

import java.util.List;

import com.medicaapp.dto.ArchivoDto;
import com.medicaapp.model.Archivo;

public interface IArchivoService {
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
	List<ArchivoDto> listarArchivos();

}
