package com.medicaapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicaapp.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
		
	//sacado desde Nombre de atributo de la clase
	Usuario findOneByUsername(String username);	
	//@query
	//bucarUsuarioPorNombre
}