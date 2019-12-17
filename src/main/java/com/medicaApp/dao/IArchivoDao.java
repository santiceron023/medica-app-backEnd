package com.medicaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicaApp.model.Archivo;

public interface IArchivoDao extends JpaRepository<Archivo, Integer>{

}
