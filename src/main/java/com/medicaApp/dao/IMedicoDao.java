package com.medicaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicaapp.model.Medico;

@Repository
public interface IMedicoDao extends JpaRepository<Medico,Integer>{

}
