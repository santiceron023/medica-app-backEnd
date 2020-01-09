package com.medicaApp.service;

import java.time.LocalDate;
import java.util.List;

import com.medicaApp.model.SignosVitales;

public interface ISignosVitalesService extends ICRUD<SignosVitales>{

	List<SignosVitales> filtro(LocalDate fecha, Integer id, String nombre);

}
