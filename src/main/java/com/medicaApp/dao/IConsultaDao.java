package com.medicaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicaApp.model.Consulta;

public interface IConsultaDao extends JpaRepository<Consulta, Integer>{

}
