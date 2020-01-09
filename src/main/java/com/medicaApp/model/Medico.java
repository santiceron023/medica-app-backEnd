package com.medicaapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer idMedico;
	
	@Column(nullable = false, length = 70)
	private String nombres;
	
	@Column(nullable = false, length = 70)
	private String apellidos;
	
	@Column(nullable = false, length = 12)
	private String cmp;
	
	
	
	public Integer getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCMP() {
		return cmp;
	}
	public void setCMP(String cMP) {
		cmp = cMP;
	}
	
		
	
}
