package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Endereco;

public class EnderecoFormularioDto {
	
	private int codigoEndereco;
	private int cepEndereco;
	private String ruaEndereco;
	private String numeroEndereco;
	private String bairroEndereco;
	private String cidadeEndereco;
	private String estadoEndereco;
	
	
	public EnderecoFormularioDto(Endereco endereco) {
		this.codigoEndereco = endereco.getCodigoEndereco();
		this.cepEndereco = endereco.getCepEndereco();
		this.ruaEndereco = endereco.getRuaEndereco();
		this.numeroEndereco = endereco.getNumeroEndereco();
		this.bairroEndereco = endereco.getBairroEndereco();
		this.cidadeEndereco = endereco.getCidadeEndereco();
		this.estadoEndereco = endereco.getEstadoEndereco();
	}
	

	public int getCodigoEndereco() {
		return codigoEndereco;
	}
	
	public int getCepEndereco() {
		return cepEndereco;
	}
	
	public String getRuaEndereco() {
		return ruaEndereco;
	}
	
	public String getNumeroEndereco() {
		return numeroEndereco;
	}
	
	public String getBairroEndereco() {
		return bairroEndereco;
	}
	
	public String getCidadeEndereco() {
		return cidadeEndereco;
	}
	
	public String getEstadoEndereco() {
		return estadoEndereco;
	}
	

}
