package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Diaria;

public class DiariaDto {
	
	private int codigoDiaria;
	private String categoriaDiaria;
	
	public DiariaDto(Diaria diaria) {
		this.codigoDiaria = diaria.getCodigoDiaria();
		this.categoriaDiaria = diaria.getCategoriaDiaria();
	}

	public int getCodigoDiaria() {
		return codigoDiaria;
	}
	
	public String getCategoriaDiaria() {
		return categoriaDiaria;
	}
	

}
