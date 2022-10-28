package br.com.contel.sistemaContel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contel.sistemaContel.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	public List<Reserva> findByDataCheckInReservaBetween(LocalDate dataInicial, LocalDate dataFinal);
	
	public List<Reserva> findByDataCadastroReserva(LocalDate dataCadastro);
	
	public List<Reserva> findByDataCancelamentoReserva(LocalDate dataCancelamento);
}