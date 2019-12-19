package com.medicaApp.service;

import java.util.List;

import com.medicaApp.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
