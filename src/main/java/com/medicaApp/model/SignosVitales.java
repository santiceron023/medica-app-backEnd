package com.medicaApp.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "signosVitales")
public class SignosVitales {
	
	@Id
	private Integer id;
	
	@JoinColumn(name = "paciente_id",nullable = false,foreignKey = @ForeignKey(name="signos_paciente"))
	@ManyToOne
	private Paciente paciente;
	
	private LocalDateTime fecha;
	
	private Float temperatura;
	
	private Float pulso;
	
	private Float ritmoRespiratorio;
	
	public Float getPulso() {
		return pulso;
	}

	public void setPulso(Float pulso) {
		this.pulso = pulso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	public Float getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	public void setRitmoRespiratorio(Float ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}
	
}
