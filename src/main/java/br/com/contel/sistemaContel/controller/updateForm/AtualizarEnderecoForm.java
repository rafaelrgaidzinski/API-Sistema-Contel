package br.com.contel.sistemaContel.controller.updateForm;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.repository.EnderecoRepository;

public class AtualizarEnderecoForm {
	
	private int cepEndereco;
	private String ruaEndereco;
	private String numeroEndereco;
	private String bairroEndereco;
	private String cidadeEndereco;
	private String estadoEndereco;
	
	
	public Endereco atualizar(int codigoEndereco, EnderecoRepository enderecoRepository) {
		
		Endereco endereco = enderecoRepository.getReferenceById(codigoEndereco);
		
		endereco.setCepEndereco(cepEndereco);
		endereco.setRuaEndereco(ruaEndereco);
		endereco.setNumeroEndereco(numeroEndereco);
		endereco.setBairroEndereco(bairroEndereco);
		endereco.setCidadeEndereco(cidadeEndereco);
		endereco.setEstadoEndereco(estadoEndereco);
		
		return endereco;
		
	}
	
	
	public int getCepEndereco() {
		return cepEndereco;
	}
	
	public void setCepEndereco(int cepEndereco) {
		this.cepEndereco = cepEndereco;
	}
	
	public String getRuaEndereco() {
		return ruaEndereco;
	}
	
	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}
	
	public String getNumeroEndereco() {
		return numeroEndereco;
	}
	
	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}
	
	public String getBairroEndereco() {
		return bairroEndereco;
	}
	
	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}
	
	public String getCidadeEndereco() {
		return cidadeEndereco;
	}
	
	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}
	
	public String getEstadoEndereco() {
		return estadoEndereco;
	}
	
	public void setEstadoEndereco(String estadoEndereco) {
		this.estadoEndereco = estadoEndereco;
	}
	

}
