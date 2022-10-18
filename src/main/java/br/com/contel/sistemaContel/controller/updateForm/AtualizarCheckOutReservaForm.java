package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.model.Reserva;
import br.com.contel.sistemaContel.repository.QuartoRepository;
import br.com.contel.sistemaContel.repository.ReservaRepository;

public class AtualizarCheckOutReservaForm {
	
	@NotNull @FutureOrPresent
	private LocalDate dataCheckOutReserva;
	
	public Reserva atualizar(Long codigoReserva, ReservaRepository reservaRepository, QuartoRepository quartoRepository) {
		
		Reserva reserva = reservaRepository.getReferenceById(codigoReserva);
		Quarto quarto = quartoRepository.getReferenceById(reserva.getQuarto().getNumeroQuarto());
		
		reserva.setDataCheckOutReserva(dataCheckOutReserva);
		quarto.setOcupado(false);
		
		return reserva;
	}

	public LocalDate getDataCheckOutReserva() {
		return dataCheckOutReserva;
	}

	public void setDataCheckOutReserva(LocalDate dataCheckOutReserva) {
		this.dataCheckOutReserva = dataCheckOutReserva;
	}


}
