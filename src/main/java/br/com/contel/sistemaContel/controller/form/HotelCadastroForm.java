package br.com.contel.sistemaContel.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.model.Hotel;
import br.com.contel.sistemaContel.repository.EnderecoRepository;

public class HotelCadastroForm {
	
	@NotNull
	private Long cnpjHotel;
	@NotEmpty
	private String nomeHotel;
	@Email
	private String emailHotel;
	private int telefoneHotel;
	private String siteHotel;
	
	private int codigoEndereco;
	
	
	public Hotel converter(EnderecoRepository enderecoRepository) {
		
		Endereco endereco = enderecoRepository.getReferenceById(codigoEndereco);
		
		return new Hotel(cnpjHotel, nomeHotel, emailHotel, telefoneHotel, siteHotel, endereco);
	}
	

	public Long getCnpjHotel() {
		return cnpjHotel;
	}

	public void setCnpjHotel(Long cnpjHotel) {
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

	public int getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
	
	

}
