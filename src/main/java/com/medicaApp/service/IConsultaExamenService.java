package com.medicaApp.service;


import java.util.List;

import com.medicaApp.model.ConsultaExamen;


public interface IConsultaExamenService{

	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
