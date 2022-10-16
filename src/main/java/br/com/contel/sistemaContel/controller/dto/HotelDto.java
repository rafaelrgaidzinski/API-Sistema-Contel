package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Hotel;

public class HotelDto {
	
	private Long cnpjHotel;
	private String nomeHotel;
	
	
	public HotelDto(Hotel hotel) {
		this.cnpjHotel = hotel.getCnpjHotel();
		this.nomeHotel = hotel.getNomeHotel();
	}
	

	public Long getCnpjHotel() {
		return cnpjHotel;
	}
	
	public String getNomeHotel() {
		return nomeHotel;
	}

}
