package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.model.Reserva;
import br.com.contel.sistemaContel.repository.QuartoRepository;
import br.com.contel.sistemaContel.repository.ReservaRepository;

public class AtualizarCheckInReservaForm {

	@NotNull @FutureOrPresent
	private LocalDate dataCheckInReserva;
	
	public Reserva atualizar(Long codigoReserva, ReservaRepository reservaRepository, QuartoRepository quartoRepository) {
		
		Reserva reserva = reservaRepository.getReferenceById(codigoReserva);
		Quarto quarto = quartoRepository.getReferenceById(reserva.getQuarto().getNumeroQuarto());
		
		reserva.setDataCheckInReserva(dataCheckInReserva);
		quarto.setOcupado(true);
		
		return reserva;
	}

	public LocalDate getDataCheckInReserva() {
		return dataCheckInReserva;
	}

	public void setDataCheckInReserva(LocalDate dataCheckInReserva) {
		this.dataCheckInReserva = dataCheckInReserva;
	}

	
}
