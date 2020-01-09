package com.medicaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicaapp.model.Archivo;

public interface IArchivoDao extends JpaRepository<Archivo, Integer>{

}
