package com.medicaapp.service;

import com.medicaapp.model.Archivo;

public interface IArchivoService {
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

}
