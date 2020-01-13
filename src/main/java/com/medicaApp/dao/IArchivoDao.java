package com.medicaapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicaapp.dto.ArchivoDto;
import com.medicaapp.model.Archivo;

@Repository
public interface IArchivoDao extends JpaRepository<Archivo, Integer>{
	
	@Query("SELECT new "
			+ "		com.medicaapp.dto.ArchivoDto("
			+ " 		a.idArchivo, a.filename, a.filetype"
			+ "		)"
			+ " FROM Archivo a")
	List<ArchivoDto> listarArchivosSinData();

}
