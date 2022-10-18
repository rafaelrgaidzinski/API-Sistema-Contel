package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import br.com.contel.sistemaContel.model.Reserva;
import br.com.contel.sistemaContel.repository.ReservaRepository;

public class AtualizarCancelarReservaForm {

	@NotNull @FutureOrPresent
	private LocalDate dataCancelamentoReserva;
	
	public Reserva atualizar(Long codigoReserva, ReservaRepository reservaRepository) {
		
		Reserva reserva = reservaRepository.getReferenceById(codigoReserva);
		
		reserva.setDataCancelamentoReserva(dataCancelamentoReserva);
		
		return reserva;
	}

	public LocalDate getDataCancelamentoReserva() {
		return dataCancelamentoReserva;
	}

	public void setDataCancelamentoReserva(LocalDate dataCancelamentoReserva) {
		this.dataCancelamentoReserva = dataCancelamentoReserva;
	}

	
}
