package com.medicaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicaapp.model.Examen;
//@Repository jpa ya lo tare
public interface IExamenDao extends JpaRepository<Examen, Integer>{

}
