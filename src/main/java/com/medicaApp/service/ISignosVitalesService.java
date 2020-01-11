package com.medicaapp.service;

import java.time.LocalDate;
import java.util.List;

import com.medicaapp.model.SignosVitales;

public interface ISignosVitalesService extends ICRUD<SignosVitales>{

	List<SignosVitales> filtro(LocalDate fecha, String string, String nombre);

}
