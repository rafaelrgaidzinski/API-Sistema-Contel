package br.com.contel.sistemaContel.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.model.Hospede;
import br.com.contel.sistemaContel.repository.EnderecoRepository;

public class HospedeCadastroForm {
	
	@NotNull
	private Long cpfHospede;
	@NotEmpty
	private String nomeHospede;
	@NotNull @Past
	private LocalDate dataNascimentoHospede;
	@Email
	private String emailHospede;
	private Long telefoneHospede;
	
	private int codigoEndereco;

	
	public Hospede converter(EnderecoRepository endeerecoRepository) {
		
		Endereco endereco = endeerecoRepository.getReferenceById(codigoEndereco);
		
		return new Hospede(cpfHospede, nomeHospede, dataNascimentoHospede, emailHospede, telefoneHospede, endereco);
	}
	
	
	public Long getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(Long cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public String getNomeHospede() {
		return nomeHospede;
	}

	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}

	public LocalDate getDataNascimentoHospede() {
		return dataNascimentoHospede;
	}

	public void setDataNascimentoHospede(LocalDate dataNascimentoHospede) {
		this.dataNascimentoHospede = dataNascimentoHospede;
	}

	public String getEmailHospede() {
		return emailHospede;
	}

	public void setEmailHospede(String emailHospede) {
		this.emailHospede = emailHospede;
	}

	public Long getTelefoneHospede() {
		return telefoneHospede;
	}

	public void setTelefoneHospede(Long telefoneHospede) {
		this.telefoneHospede = telefoneHospede;
	}

	public int getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}
	

}
