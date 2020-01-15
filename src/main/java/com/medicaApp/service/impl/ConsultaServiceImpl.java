package com.medicaapp.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.medicaapp.dao.IConsultaDao;
import com.medicaapp.dao.IConsultaExamenDao;
import com.medicaapp.dto.ConsultaListaExamenDto;
import com.medicaapp.dto.ConsultaResumenDto;
import com.medicaapp.dto.FiltroConsultarDto;
import com.medicaapp.model.Consulta;
import com.medicaapp.service.IConsultaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ConsultaServiceImpl implements IConsultaService {

	@Autowired
	IConsultaExamenDao conExaDao;

	@Autowired
	IConsultaDao conDao;

	//consultaDetalle
	@Override
	public Consulta registrar(Consulta con) { 

		con.setFecha( LocalDateTime.of(
				con.getFecha().toLocalDate(),LocalTime.now()
				));

		con.getDetalleConsulta().forEach(
				detalle -> detalle.setConsulta(con) 
				);
		return conDao.save(con);
	}

	@Override
	//Transaccional -> si hay un error en alguna entidad, hace roolback de todo
	@Transactional 
	//consulta+detalle+exámen
	public Consulta registrarTransaccional(ConsultaListaExamenDto dto) { 

		dto.getConsulta().setFecha( LocalDateTime.of(
				dto.getConsulta().getFecha().toLocalDate(),LocalTime.now()
				));

		dto.getConsulta().getDetalleConsulta().forEach(
				detalle -> detalle.setConsulta(dto.getConsulta()) 
				);
		conDao.save(dto.getConsulta());

		//insertar cada examen de la consulta(Ya creada)
		dto.getExamenList().forEach(
				exam -> conExaDao.registrar(
						dto.getConsulta().getIdConsulta(),exam.getIdExamen() )
				);	

		return dto.getConsulta();
	}

	//	modificar(Consulta t)
	//	eliminar(Integer id)

	@Override
	public List<Consulta> listar() {
		return conDao.findAll();
	}

	@Override
	public Consulta listarPorId(Integer id) {
		Optional<Consulta> opt = conDao.findById(id);
		return opt.isPresent() ? opt.get() : new Consulta();
	}

	@Override
	public List<Consulta> buscar(FiltroConsultarDto filtro) {
		return conDao.buscar(filtro.getDocumentId(), filtro.getNombreCompleto());
	}


	@Override
	public List<Consulta> buscarFecha(FiltroConsultarDto filtro) {
		LocalDateTime fechaMax = filtro.getFechaConsulta().atTime(LocalTime.MAX);
		return conDao.buscar(
				filtro.getFechaConsulta().atTime(LocalTime.MIN), fechaMax);
	}


	@Override
	public List<ConsultaResumenDto> listarResumen() {
		List<ConsultaResumenDto> consulta = new ArrayList<ConsultaResumenDto>();
		// IMPORTANTE: se mapea porque es un procedimiento
		conDao.listarResumen().forEach( x -> {
			ConsultaResumenDto item = new ConsultaResumenDto();
			item.setCantidad((int) x[0] );
			item.setFecha((String) x[1]);
			consulta.add(item);
		});
		return consulta;
	}


	@Override
	public byte[] generarReporte() {
		byte[] data= null;
		try {
			File file = new ClassPathResource("/reports/consultas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(),
					null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}




}
