package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.model.Hospede;
import br.com.contel.sistemaContel.repository.EnderecoRepository;
import br.com.contel.sistemaContel.repository.HospedeRepository;

public class AtualizarHospedeForm {
	
	@NotEmpty
	private String nomeHospede;
	@NotNull @Past
	private LocalDate dataNascimentoHospede;
	@Email
	private String emailHospede;
	private Long telefoneHospede;
	
	private int codigoEndereco;
	
	
	public Hospede atualizar(Long cpfHospede, HospedeRepository hospedeRepository, EnderecoRepository enderecoRepository) {
		
		Hospede hospede = hospedeRepository.getReferenceById(cpfHospede);
		Endereco endereco = enderecoRepository.getReferenceById(codigoEndereco);
		
		hospede.setNomeHospede(nomeHospede);
		hospede.setDataNascimentoHospede(dataNascimentoHospede);
		hospede.setEmailHospede(emailHospede);
		hospede.setTelefoneHospede(telefoneHospede);
		hospede.setEndereco(endereco);
		
		return hospede;
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
