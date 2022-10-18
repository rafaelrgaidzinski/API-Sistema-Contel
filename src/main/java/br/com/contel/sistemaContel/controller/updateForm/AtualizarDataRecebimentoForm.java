package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import br.com.contel.sistemaContel.model.Receita;
import br.com.contel.sistemaContel.repository.ReceitaRepository;

public class AtualizarDataRecebimentoForm {

	@NotNull @FutureOrPresent
	private LocalDate dataRecebimento;
	
	
	public Receita atualizar(Long codigoReceita, ReceitaRepository receitaRepository ) {
		
		Receita receita = receitaRepository.getReferenceById(codigoReceita);
		
		receita.setDataRecebimento(dataRecebimento);
		
		return receita;
	}
	

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	
	
}
