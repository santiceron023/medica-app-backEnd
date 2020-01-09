package com.medicaapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicaapp.model.SignosVitales;

public interface ISignosVitalesDao extends JpaRepository<SignosVitales, Integer> {

	@Query(
			"FROM SignosVitales s WHERE"
			+ " (s.paciente.idPaciente = NULL or s.paciente.idPaciente = :id)"
			+ " AND (s.paciente.nombres = NULL or s.paciente.nombres LIKE :nombre)"
			+ " AND (s.fecha = NULL or ( s.fecha BETWEEN :fecha1 AND :fecha2 ) ) "
			)
	List<SignosVitales> filtro(
			@Param(value = "fecha1") LocalDateTime fechaInicio,
			@Param("fecha2") LocalDateTime fechaFin,
			@Param("id") Integer id, 
			@Param("nombre") String nombre);	
}
