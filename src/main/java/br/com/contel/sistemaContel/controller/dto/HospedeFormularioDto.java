package br.com.contel.sistemaContel.controller.dto;

import java.time.LocalDate;

import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.model.Hospede;

public class HospedeFormularioDto {
	
	private Long cpfHospede;
	private String nomeHospede;
	private LocalDate dataNascimentoHospede;
	private String emailHospede;
	private Long telefoneHospede;
	
	private Endereco endereco;
	
	
	public HospedeFormularioDto(Hospede hospede) {
		this.cpfHospede = hospede.getCpfHospede();
		this.nomeHospede = hospede.getNomeHospede();
		this.dataNascimentoHospede = hospede.getDataNascimentoHospede();
		this.emailHospede = hospede.getEmailHospede();
		this.telefoneHospede = hospede.getTelefoneHospede();
		this.endereco = hospede.getEndereco();
	}
	

	public Long getCpfHospede() {
		return cpfHospede;
	}

	public String getNomeHospede() {
		return nomeHospede;
	}

	public LocalDate getDataNascimentoHospede() {
		return dataNascimentoHospede;
	}

	public String getEmailHospede() {
		return emailHospede;
	}

	public Long getTelefoneHospede() {
		return telefoneHospede;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	

}
