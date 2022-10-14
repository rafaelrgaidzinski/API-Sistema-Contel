package br.com.contel.sistemaContel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hotel {
	
	@Id
	private int cnpjHotel;
	private String nomeHotel;
	private String emailHotel;
	private int telefoneHotel;
	private String siteHotel;
	
	@OneToOne
	private Endereco endereco;
	
	
	public Hotel() {
		
	}

	public Hotel(int cnpjHotel, String nomeHotel, String emailHotel, int telefoneHotel, String siteHotel,
			Endereco endereco) {
		this.cnpjHotel = cnpjHotel;
		this.nomeHotel = nomeHotel;
		this.emailHotel = emailHotel;
		this.telefoneHotel = telefoneHotel;
		this.siteHotel = siteHotel;
		this.endereco = endereco;
	}


	public int getCnpjHotel() {
		return cnpjHotel;
	}


	public void setCnpjHotel(int cnpjHotel) {
		this.cnpjHotel = cnpjHotel;
	}


	public String getNomeHotel() {
		return nomeHotel;
	}


	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}


	public String getEmailHotel() {
		return emailHotel;
	}


	public void setEmailHotel(String emailHotel) {
		this.emailHotel = emailHotel;
	}


	public int getTelefoneHotel() {
		return telefoneHotel;
	}


	public void setTelefoneHotel(int telefoneHotel) {
		this.telefoneHotel = telefoneHotel;
	}


	public String getSiteHotel() {
		return siteHotel;
	}


	public void setSiteHotel(String siteHotel) {
		this.siteHotel = siteHotel;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}