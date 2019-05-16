package com.medicaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicaApp.model.Paciente;

public interface IPacienteDao extends JpaRepository<Paciente,Integer>{

}
