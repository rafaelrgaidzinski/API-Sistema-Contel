package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Quarto;

public class QuartoDto {
	
	private String numeroQuarto;

	
	public QuartoDto(Quarto quarto) {
		this.numeroQuarto = quarto.getNumeroQuarto();
	}
	

	public String getNumeroQuarto() {
		return numeroQuarto;
	}
	

}
