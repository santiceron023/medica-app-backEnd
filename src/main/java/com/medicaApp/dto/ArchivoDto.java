package com.medicaapp.dto;

public class ArchivoDto {
	
	private int idArchivo;
	private String filename;
	private String filetype;
	
	
	
	public ArchivoDto(int idArchivo, String filename, String filetype) {
		this.idArchivo = idArchivo;
		this.filename = filename;
		this.filetype = filetype;
	}
	
	public int getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
	

}
