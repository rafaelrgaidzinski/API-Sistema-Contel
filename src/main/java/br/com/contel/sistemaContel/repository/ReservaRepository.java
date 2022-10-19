package br.com.contel.sistemaContel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.contel.sistemaContel.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	static final String CASE_WHEN="\nCASE\n"
            + "    WHEN :diaSemana = '0' THEN d.valorDiariaDomingo\n"
            + "    WHEN :diaSemana = '1' THEN d.valorDiariaSegunda\n"
            + "    WHEN :diaSemana = '2' THEN d.valorDiariaTerca\n"
            + "    WHEN :diaSemana = '3' THEN d.valorDiariaQuarta\n"
            + "    WHEN :diaSemana = '4' THEN d.valorDiariaQuinta\n"
            + "    WHEN :diaSemana = '5' THEN d.valorDiariaSexta\n"
            + "    WHEN :diaSemana = '6' THEN d.valorDiariaSabado\n"
            + "    ELSE 0\n"
            + "END\n";
	
	@Query(value=("Select sum("+ CASE_WHEN +")"
			+ "/"
			+ "count(q.numeroQuarto) "
			+ "FROM Reserva r "
			+ "INNER JOIN Quarto q ON q.numeroQuarto = r.quarto_numeroQuarto "
			+ "INNER JOIN Diaria d ON q.diaria_codigoDiaria = d.codigoDiaria "
			+ "WHERE r.dataCheckInReserva >= :dataAtual "
			+ "AND r.dataCheckOutReserva <= :dataAtual "
			),
			nativeQuery = true) 
	double findDiariaMedia(@PathVariable int diaSemana, @PathVariable String dataAtual);

	public List<Reserva> findByDataCheckInReservaBetween(LocalDate dataInicial, LocalDate dataFinal);
	
	public List<Reserva> findByDataCheckOutReservaBetween(LocalDate dataInicial, LocalDate dataFinal);
	
	public List<Reserva> findByDataCadastroReserva(LocalDate dataCadastro);
	
	public List<Reserva> findByDataCancelamentoReserva(LocalDate dataCancelamento);
	
	@Query(value=("Select sum(r.quantidadeHospedes) "
			+ "FROM Reserva r "
			+ "INNER JOIN Quarto q ON q.numeroQuarto = r.quarto_numeroQuarto "
			+ "INNER JOIN Diaria d ON q.diaria_codigoDiaria = d.codigoDiaria "
			+ "WHERE r.dataCheckInReserva >= :dataAtual "
			+ "AND r.dataCheckOutReserva <= :dataAtual"
			),
			nativeQuery = true) 
	int findQntHospedes(LocalDate dataAtual);
	
}