package br.com.contel.sistemaContel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.contel.sistemaContel.model.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, String> {
	
	@Query(value=("SELECT ((sum(q.quantidadeCamaCasal)*2) + (sum(q.quantidadeCamaSolteiro))) "
			+ "FROM Quarto q"
			), 
			nativeQuery = true
		)
	int findQntHospedeQuarto();
	

}
