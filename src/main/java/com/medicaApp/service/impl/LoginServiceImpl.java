package com.medicaapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaapp.dao.ILoginDao;
import com.medicaapp.model.Usuario;
import com.medicaapp.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginDao loginDao;

	@Override
	public Usuario verificarNombreUsuario(String userName) throws Exception {
		Usuario usuario =  loginDao.verificarUsarioPorNombre(userName);
		usuario = (usuario != null) ? usuario : new Usuario();
		return usuario;
	}

	@Override
	public int cambiarClave(String clave, String nombre) throws Exception {
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
