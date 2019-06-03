package com.medicaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicaApp.model.Especialidad;
import com.medicaApp.model.Medico;
import com.medicaApp.model.Paciente;

@Repository
public interface IEspecialidadDao extends JpaRepository<Especialidad,Integer>{

}
