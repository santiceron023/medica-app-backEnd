package com.medicaapp.service;


import java.util.List;

import com.medicaapp.model.ConsultaExamen;


public interface IConsultaExamenService{

	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
