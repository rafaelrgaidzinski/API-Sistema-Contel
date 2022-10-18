package br.com.contel.sistemaContel.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.contel.sistemaContel.model.Reserva;

public class ReservaIndicadoresDto {
	
	private LocalDate dataCadastroReserva;
	private LocalDate dataCancelamentoReserva;
	
	
	public ReservaIndicadoresDto(Reserva reserva) {
		this.dataCadastroReserva = reserva.getDataCadastroReserva();
		this.dataCancelamentoReserva = reserva.getDataCancelamentoReserva();
	}
	
	public static List<ReservaIndicadoresDto> converter(List<Reserva> reservas) {
		
		return reservas.stream().map(ReservaIndicadoresDto::new).collect(Collectors.toList());
	}

	public LocalDate getDataCadastroReserva() {
		return dataCadastroReserva;
	}
	
	public LocalDate getDataCancelamentoReserva() {
		return dataCancelamentoReserva;
	}
	
	
}
