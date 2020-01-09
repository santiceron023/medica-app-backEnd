package com.medicaapp.service;

import com.medicaapp.model.Usuario;

public interface ILoginService {
	
	Usuario verificarNombreUsuario(String username) throws Exception;
	int cambiarClave(String clave, String nombre) throws Exception;

}
