package br.com.contel.sistemaContel.controller.updateForm;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.contel.sistemaContel.model.Despesa;
import br.com.contel.sistemaContel.repository.DespesaRepository;

public class AtualizarDespesaForm {

	@NotNull @PositiveOrZero
	private double valorDespesa;
	private String descricaoDespesa;
	@NotEmpty
	private String categoriaDespesa;
	@NotNull @FutureOrPresent
	private LocalDate vencimentoDespesa;
	@FutureOrPresent
	private LocalDate dataPagamento;
	
	
	public Despesa atualizar(Long codigoDespesa, DespesaRepository despesaRepository) {
		
		Despesa despesa = despesaRepository.getReferenceById(codigoDespesa);
		
		despesa.setValorDespesa(valorDespesa);
		despesa.setDescricaoDespesa(descricaoDespesa);
		despesa.setCategoriaDespesa(categoriaDespesa);
		despesa.setVencimentoDespesa(vencimentoDespesa);
		despesa.setDataPagamento(dataPagamento);
		
		return despesa;
	}
	
	
	public double getValorDespesa() {
		return valorDespesa;
	}
	
	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}
	
	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}
	
	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	
	public String getCategoriaDespesa() {
		return categoriaDespesa;
	}
	
	public void setCategoriaDespesa(String categoriaDespesa) {
		this.categoriaDespesa = categoriaDespesa;
	}
	
	public LocalDate getVencimentoDespesa() {
		return vencimentoDespesa;
	}
	
	public void setVencimentoDespesa(LocalDate vencimentoDespesa) {
		this.vencimentoDespesa = vencimentoDespesa;
	}
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
}
