package com.medicaapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medicaapp.model.Consulta;

public interface IConsultaDao extends JpaRepository<Consulta, Integer>{

	//JPQL
	@Query("FROM Consulta con"
			+ " WHERE"
			+ "		con.paciente.dni = :dni "
			+ "		OR LOWER(con.paciente.nombres) like %:nombreCompleto%"
			+ "		OR LOWER(con.paciente.apellidos) like %:nombreCompleto%"
			+ " ORDER BY con.fecha DESC")
	List<Consulta> buscar(
			@Param("dni") String dni,
			@Param("nombreCompleto") String nombreCompleto);

	//JPQL
	@Query("FROM Consulta con"
			+ " WHERE"
			+ " 	con.fecha between :fechaConsulta and :fechaSgte"
			+ " ORDER BY con.fecha DESC")
	List<Consulta> buscar(
			@Param("fechaConsulta") LocalDateTime fechaConsulta,
			@Param("fechaSgte") LocalDateTime fechaSgte);


	//cantidad Fecha --------PROCEDIMIENTO ALMACENADO------------
	//[2, 10/20/1993]
	@Query(value="select * from fn_listarResumen()",nativeQuery = true)
	List<Object[]> listarResumen();
	
	@Query("FROM Consulta con ORDER BY con.fecha DESC")
	List<Consulta> listarOrderbyFecha();


}
