package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Reserva;

public class ReservaDto {

	private Long codigoReserva;

	
	public ReservaDto(Reserva reserva) {
		this.codigoReserva = reserva.getCodigoReserva();
	}


	public Long getCodigoReserva() {
		return codigoReserva;
	}
	
	
}
