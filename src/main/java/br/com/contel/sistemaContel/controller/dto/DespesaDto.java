package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Despesa;

public class DespesaDto {

	private Long codigoDespesa;

	
	public DespesaDto(Despesa despesa) {
		this.codigoDespesa = despesa.getCodigoDespesa();
	}


	public Long getCodigoDespesa() {
		return codigoDespesa;
	}
	
	
}
