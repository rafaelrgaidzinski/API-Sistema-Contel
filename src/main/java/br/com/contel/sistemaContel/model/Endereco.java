package br.com.contel.sistemaContel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoEndereco;
	private int cepEndereco;
	private String ruaEndereco;
	private String numeroEndereco;
	private String bairroEndereco;
	private String cidadeEndereco;
	private String estadoEndereco;
	
	public Endereco() {
		
	}

	public Endereco(int codigoEndereco, int cepEndereco, String ruaEndereco, String numeroEndereco,
			String bairroEndereco, String cidadeEndereco, String estadoEndereco) {
		this.codigoEndereco = codigoEndereco;
		this.cepEndereco = cepEndereco;
		this.ruaEndereco = ruaEndereco;
		this.numeroEndereco = numeroEndereco;
		this.bairroEndereco = bairroEndereco;
		this.cidadeEndereco = cidadeEndereco;
		this.estadoEndereco = estadoEndereco;
	}

	public int getCodigoEndereco() {
		return codigoEndereco;
	}
	
	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
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
