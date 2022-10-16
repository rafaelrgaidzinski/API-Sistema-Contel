package br.com.contel.sistemaContel.controller.updateForm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.model.Hotel;
import br.com.contel.sistemaContel.repository.EnderecoRepository;
import br.com.contel.sistemaContel.repository.HotelRepository;

public class AtualizarHotelForm {
	
	@NotEmpty
	private String nomeHotel;
	@Email
	private String emailHotel;
	private int telefoneHotel;
	private String siteHotel;
	
	private int codigoEndereco;
	
	public Hotel atualizar(Long cnpjHotel, HotelRepository hotelRepository, EnderecoRepository enderecoRepository) {
		
		Hotel hotel = hotelRepository.getReferenceById(cnpjHotel);
		Endereco endereco = enderecoRepository.getReferenceById(codigoEndereco);
		
		hotel.setNomeHotel(nomeHotel);
		hotel.setEmailHotel(emailHotel);
		hotel.setTelefoneHotel(telefoneHotel);
		hotel.setSiteHotel(siteHotel);
		hotel.setEndereco(endereco);
		
		return hotel;
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

	public int getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
	

}
