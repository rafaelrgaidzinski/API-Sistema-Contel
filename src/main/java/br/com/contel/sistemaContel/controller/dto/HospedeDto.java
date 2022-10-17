package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Hospede;

public class HospedeDto {
	
	private Long cpfHospede;
	private String nomeHospede;
	
	
	public HospedeDto(Hospede hospede) {
		this.cpfHospede = hospede.getCpfHospede();
		this.nomeHospede = hospede.getNomeHospede();
	}
	

	public Long getCpfHospede() {
		return cpfHospede;
	}
	
	public String getNomeHospede() {
		return nomeHospede;
	}
	

}
