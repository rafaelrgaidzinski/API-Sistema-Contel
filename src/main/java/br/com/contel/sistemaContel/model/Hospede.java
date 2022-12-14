package br.com.contel.sistemaContel.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hospede {
	
	@Id
	private Long cpfHospede;
	private String nomeHospede;
	private LocalDate dataNascimentoHospede;
	private String emailHospede;
	private Long telefoneHospede;
	
	@OneToOne
	private Endereco endereco;
	
	public Hospede() {
		
	}

	public Hospede(Long cpfHospede, String nomeHospede, LocalDate dataNascimentoHospede, String emailHospede,
			Long telefoneHospede, Endereco endereco) {
		this.cpfHospede = cpfHospede;
		this.nomeHospede = nomeHospede;
		this.dataNascimentoHospede = dataNascimentoHospede;
		this.emailHospede = emailHospede;
		this.telefoneHospede = telefoneHospede;
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}