package com.medicaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicaApp.model.Paciente;

@Repository
public interface IPacienteDao extends JpaRepository<Paciente,Integer>{

}
