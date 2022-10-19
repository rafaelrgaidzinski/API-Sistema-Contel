package br.com.contel.sistemaContel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contel.sistemaContel.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	public List<Despesa> findByVencimentoDespesaBetween (LocalDate dataInicial, LocalDate dataFinal);
	
	public List<Despesa> findByDataPagamento (LocalDate data);
}
