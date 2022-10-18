package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.contel.sistemaContel.model.Hospede;
import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.model.Reserva;
import br.com.contel.sistemaContel.repository.HospedeRepository;
import br.com.contel.sistemaContel.repository.QuartoRepository;
import br.com.contel.sistemaContel.repository.ReservaRepository;

public class AtualizarReservaForm {
	
	@NotEmpty
	private String situacaoReserva;
	@NotNull @Positive
	private int quantidadeHospedes;
	@NotNull @FutureOrPresent
	private LocalDate dataCheckInReserva;
	@NotNull @FutureOrPresent
	private LocalDate dataCheckOutReserva;
	private String observacaoReserva;
	
	@NotNull
	private Long cpfHospede;
	@NotEmpty
	private String numeroQuarto;
	
	
	public Reserva atualizar(Long codigoReserva, ReservaRepository reservaRepository, HospedeRepository hospedeRepository, QuartoRepository quartoRepository) {
		
		Reserva reserva = reservaRepository.getReferenceById(codigoReserva);
		Hospede hospede = hospedeRepository.getReferenceById(cpfHospede);
		Quarto quarto = quartoRepository.getReferenceById(numeroQuarto);
		
		reserva.setSituacaoReserva(situacaoReserva);
		reserva.setQuantidadeHospedes(quantidadeHospedes);
		reserva.setDataCheckInReserva(dataCheckInReserva);
		reserva.setDataCheckOutReserva(dataCheckOutReserva);
		reserva.setObservacaoReserva(observacaoReserva);
		reserva.setHospede(hospede);
		reserva.setQuarto(quarto);
		
		return reserva;
	}


	public String getSituacaoReserva() {
		return situacaoReserva;
	}


	public void setSituacaoReserva(String situacaoReserva) {
		this.situacaoReserva = situacaoReserva;
	}


	public int getQuantidadeHospedes() {
		return quantidadeHospedes;
	}


	public void setQuantidadeHospedes(int quantidadeHospedes) {
		this.quantidadeHospedes = quantidadeHospedes;
	}


	public LocalDate getDataCheckInReserva() {
		return dataCheckInReserva;
	}


	public void setDataCheckInReserva(LocalDate dataCheckInReserva) {
		this.dataCheckInReserva = dataCheckInReserva;
	}


	public LocalDate getDataCheckOutReserva() {
		return dataCheckOutReserva;
	}


	public void setDataCheckOutReserva(LocalDate dataCheckOutReserva) {
		this.dataCheckOutReserva = dataCheckOutReserva;
	}


	public String getObservacaoReserva() {
		return observacaoReserva;
	}


	public void setObservacaoReserva(String observacaoReserva) {
		this.observacaoReserva = observacaoReserva;
	}


	public Long getCpfHospede() {
		return cpfHospede;
	}


	public void setCpfHospede(Long cpfHospede) {
		this.cpfHospede = cpfHospede;
	}


	public String getNumeroQuarto() {
		return numeroQuarto;
	}


	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	

}
