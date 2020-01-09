package com.medicaapp.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medicaapp.dao.IEspecialidadDao;
import com.medicaapp.model.Especialidad;
import com.medicaapp.service.IEspecialidadService;


@Service
public class EspecialidadServiceImpl implements IEspecialidadService{


	@Autowired
	IEspecialidadDao especialidadDao;

	@Override
	public Especialidad registrar(Especialidad t) {
		return especialidadDao.save(t);
	}

	@Override
	public Especialidad modificar(Especialidad t) {
		return especialidadDao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		//INI-CAMBIO PARA SPRING BOOT 2
		especialidadDao.deleteById(id);

	}

	@Override
	public List<Especialidad> listar() {
		return especialidadDao.findAll();
	}

	@Override
	public Especialidad listarPorId(Integer id) {
		Optional<Especialidad> opt = especialidadDao.findById(id);
		return opt.isPresent() ? opt.get() : new Especialidad();
	}

}
