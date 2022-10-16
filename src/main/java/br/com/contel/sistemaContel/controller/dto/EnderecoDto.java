package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Endereco;

public class EnderecoDto {
	
	private int codigoEndereco;
	
	public EnderecoDto(Endereco endereco) {
		this.codigoEndereco = endereco.getCodigoEndereco();
	}

	public int getCodigoEndereco() {
		return codigoEndereco;
	}

}
