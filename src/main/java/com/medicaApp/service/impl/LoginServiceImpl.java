package com.medicaApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaApp.dao.ILoginDao;
import com.medicaApp.model.Usuario;
import com.medicaApp.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginDao loginDao;

	@Override
	public Usuario verificarNombreUsuario(String Username) throws Exception {
		Usuario usuario =  loginDao.verificarUsarioPorNombre(Username);
		usuario = (usuario != null) ? usuario : new Usuario();
		return usuario;
	}

	@Override
	public int CambiarClave(String clave, String nombre) throws Exception {
		int rta = 0;
		try {
			this.loginDao.cambiarClave(clave, nombre);
			rta=1;
		} catch (Exception e) {
			throw new Exception(e);
		}
		return rta;
	}


}
