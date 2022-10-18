package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Receita;

public class ReceitaDto {
	
	private Long codigoReceita;

	
	public ReceitaDto(Receita receita) {
		this.codigoReceita = receita.getCodigoReceita();
	}
	

	public Long getCodigoReceita() {
		return codigoReceita;
	}


}
