package com.medicaapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicaapp.model.SignosVitales;

public interface ISignosVitalesDao extends JpaRepository<SignosVitales, Integer> {

	@Query(value =
			"FROM SignosVitales s "
			+ " WHERE "
			+ " 	(:id = NULL or s.paciente.dni LIKE :id)"
			+ " 	AND (:nombre = NULL or s.paciente.nombres LIKE :nombre)"
			+ " 	AND ( (CAST(:fecha1 AS java.time.LocalDateTime)) IS NULL or ( s.fecha BETWEEN :fecha1 AND :fecha2 ) )"
			+ " ORDER BY s.fecha DESC"
			)
	List<SignosVitales> filtro(
			@Param(value = "fecha1") LocalDateTime fechaInicio,
			@Param("fecha2") LocalDateTime fechaFin,
			@Param("id") String id, 
			@Param("nombre") String nombre);
}
