package br.com.contel.sistemaContel.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.contel.sistemaContel.model.Hospede;
import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.model.Reserva;

public class ReservaFormularioDto {

	private Long codigoReserva;
	private String situacaoReserva;
	private int quantidadeHospedes;
	private String observacaoReserva;
	private LocalDate dataCheckInReserva;
	private LocalDate dataCheckOutReserva;
	
	private Quarto quarto;
	private Hospede hospede;
	
	
	public ReservaFormularioDto(Reserva reserva) {
		this.codigoReserva = reserva.getCodigoReserva();
		this.situacaoReserva = reserva.getSituacaoReserva();
		this.quantidadeHospedes = reserva.getQuantidadeHospedes();
		this.observacaoReserva = reserva.getObservacaoReserva();
		this.dataCheckInReserva = reserva.getDataCheckInReserva();
		this.dataCheckOutReserva = reserva.getDataCheckOutReserva();
		this.quarto = reserva.getQuarto();
		this.hospede = reserva.getHospede();
	}
	
	public static List<ReservaFormularioDto> converter(List<Reserva> reservas) {
		
		return reservas.stream().map(ReservaFormularioDto::new).collect(Collectors.toList());
	}
	

	public Long getCodigoReserva() {
		return codigoReserva;
	}
	
	public String getSituacaoReserva() {
		return situacaoReserva;
	}
	
	public int getQuantidadeHospedes() {
		return quantidadeHospedes;
	}
	
	public String getObservacaoReserva() {
		return observacaoReserva;
	}
	
	public LocalDate getDataCheckInReserva() {
		return dataCheckInReserva;
	}
	
	public LocalDate getDataCheckOutReserva() {
		return dataCheckOutReserva;
	}
	
	public Quarto getQuarto() {
		return quarto;
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	
	
}
