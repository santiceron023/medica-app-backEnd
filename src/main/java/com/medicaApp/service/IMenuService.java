package com.medicaapp.service;

import java.util.List;

import com.medicaapp.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
