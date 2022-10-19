package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import br.com.contel.sistemaContel.model.Despesa;
import br.com.contel.sistemaContel.repository.DespesaRepository;

public class AtualizarDataPagamentoForm {
	
	@NotNull @FutureOrPresent
	private LocalDate dataPagamento;
	
	
	public Despesa atualizar(Long codigoDespesa, DespesaRepository despesaRepository) {
		
		Despesa despesa = despesaRepository.getReferenceById(codigoDespesa);
		
		despesa.setDataPagamento(dataPagamento);
		
		return despesa;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
}
