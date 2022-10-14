package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.model.Hotel;

public class HotelFormularioDto {
	
	private int cnpjHotel;
	private String nomeHotel;
	private String emailHotel;
	private int telefoneHotel;
	private String siteHotel;
	private Endereco endereco;
	
	
	public HotelFormularioDto(Hotel hotel) {
		this.cnpjHotel = hotel.getCnpjHotel();
		this.nomeHotel = hotel.getNomeHotel();
		this.emailHotel = hotel.getEmailHotel();
		this.telefoneHotel = hotel.getTelefoneHotel();
		this.siteHotel = hotel.getSiteHotel();
		this.endereco = hotel.getEndereco();
	}

	
	public int getCnpjHotel() {
		return cnpjHotel;
	}
	
	public String getNomeHotel() {
		return nomeHotel;
	}
	
	public String getEmailHotel() {
		return emailHotel;
	}
	
	public int getTelefoneHotel() {
		return telefoneHotel;
	}
	
	public String getSiteHotel() {
		return siteHotel;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	

}
