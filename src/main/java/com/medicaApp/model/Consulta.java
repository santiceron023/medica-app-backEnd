package com.medicaApp.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsulta;
	
	//un paciente muchas consultas
	@ManyToOne
	//muchas consultas puede tener un paciente
	@JoinColumn(name = "id_paciente",nullable= false, foreignKey = @ForeignKey(name = "consulta_paciente") )
	private Paciente paciente;
	
	@ManyToOne
	//nombre de la columna
	@JoinColumn(name = "id_medico",nullable= false, foreignKey = @ForeignKey(name = "consulta_medico") )
	private Medico medico;
	
	@ManyToOne
	//freingkey es para noombre del cnsrain
	@JoinColumn(name = "id_especialidad",nullable= false, foreignKey = @ForeignKey(name = "consulta_especialidad"))
	private Especialidad especialidad;
	//para recibir lista de detalle consulta
	//mapeo bidireccional solo en maestro detalle
	//no se agrega a base de datos, porq tiene maped by
	
	
	
	
	//dar formato a la fecha  ISODate 2019-10-01T05:00:00.000
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;

	
	
	
	
	//fetch lazy para que no traiga la consulta, si le pongo eager tre todos los detales
	@OneToMany(mappedBy="consulta",cascade = {CascadeType.PERSIST,
			CascadeType.MERGE,CascadeType.REMOVE},fetch=FetchType.LAZY
			,orphanRemoval = false)
	//cascade para que padre cree al hijo
	//nombre del que mapea a consulta en detalleconsulta(atr de java)
	private List<DetalleConsulta> detalleConsulta;
	
	//orphan permite eliminar elementos del detalle
	
	
	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}

	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
