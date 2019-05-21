package com.medicaApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicaApp.model.ConsultaExamen;

public interface IConsultaExamenDao extends JpaRepository<ConsultaExamen, Integer>{

	
	//SQL, puedo poner :idExame o ?1, ?2
	@Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta,:idExamen)"
			, nativeQuery = true)
	Integer registrar(@Param("idConsulta") Integer idConsulta,@Param("idExamen") Integer idExamen);
}