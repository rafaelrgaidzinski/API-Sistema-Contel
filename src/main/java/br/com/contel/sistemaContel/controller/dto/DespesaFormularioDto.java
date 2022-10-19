package br.com.contel.sistemaContel.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.contel.sistemaContel.model.Despesa;

public class DespesaFormularioDto {
	
	private Long codigoDespesa;
	private double valorDespesa;
	private String descricaoDespesa;
	private String categoriaDespesa;
	private LocalDate vencimentoDespesa;
	private LocalDate dataPagamento;
	
	public DespesaFormularioDto(Despesa despesa) {
		this.codigoDespesa = despesa.getCodigoDespesa();
		this.valorDespesa = despesa.getValorDespesa();
		this.descricaoDespesa = despesa.getDescricaoDespesa();
		this.categoriaDespesa = despesa.getCategoriaDespesa();
		this.vencimentoDespesa = despesa.getVencimentoDespesa();
		this.dataPagamento = despesa.getDataPagamento();
	}
	
	public static List<DespesaFormularioDto> converter(List<Despesa> despesas) {
		
		return despesas.stream().map(DespesaFormularioDto::new).collect(Collectors.toList());
	}

	public Long getCodigoDespesa() {
		return codigoDespesa;
	}
	
	public double getValorDespesa() {
		return valorDespesa;
	}
	
	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}
	
	public String getCategoriaDespesa() {
		return categoriaDespesa;
	}
	
	public LocalDate getVencimentoDespesa() {
		return vencimentoDespesa;
	}
	
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	

}
