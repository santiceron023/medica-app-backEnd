package com.medicaApp.service;

import com.medicaApp.model.Archivo;

public interface IArchivoService {
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

}
