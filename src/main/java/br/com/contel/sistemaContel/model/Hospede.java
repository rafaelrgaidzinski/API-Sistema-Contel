package br.com.contel.sistemaContel.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospede {
	
	@Id
	private int cpfHospede;
	private String nomeHospede;
	private LocalDate dataNascimentoHospede;
	private String emailHospede;
	private int telefoneHospede;
	
	//foreign key codigoEndereco
	
	public Hospede() {
		
	}

	public Hospede(int cpfHospede, String nomeHospede, LocalDate dataNascimentoHospede, String emailHospede,
			int telefoneHospede) {
		this.cpfHospede = cpfHospede;
		this.nomeHospede = nomeHospede;
		this.dataNascimentoHospede = dataNascimentoHospede;
		this.emailHospede = emailHospede;
		this.telefoneHospede = telefoneHospede;
	}


	public int getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(int cpfHospede) {
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

	public int getTelefoneHospede() {
		return telefoneHospede;
	}

	public void setTelefoneHospede(int telefoneHospede) {
		this.telefoneHospede = telefoneHospede;
	}

	
}
