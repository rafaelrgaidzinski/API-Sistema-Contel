package br.com.contel.sistemaContel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contel.sistemaContel.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	public List<Receita> findByVencimentoReceitaBetween (LocalDate dataInicial, LocalDate dataFinal);

}
