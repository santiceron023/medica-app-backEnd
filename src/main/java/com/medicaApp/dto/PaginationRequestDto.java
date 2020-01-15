package com.medicaapp.dto;

public class PaginationRequestDto {
	private Integer tamano;
	private Integer pagina;
	
//	private String sortBy;
	
	public Integer getTamano() {
		return tamano;
	}
	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}	

}
