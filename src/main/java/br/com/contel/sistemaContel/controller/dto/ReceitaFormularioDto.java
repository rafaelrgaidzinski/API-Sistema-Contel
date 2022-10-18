package br.com.contel.sistemaContel.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.contel.sistemaContel.model.Receita;

public class ReceitaFormularioDto {
	
	private Long codigoReceita;
	private double valorReceita;
	private String descricaoReceita;
	private String categoriaReceita;
	private LocalDate vencimentoReceita;
	private LocalDate dataRecebimento;
	
	
	public ReceitaFormularioDto(Receita receita) {
		this.codigoReceita = receita.getCodigoReceita();
		this.valorReceita = receita.getValorReceita();
		this.descricaoReceita = receita.getDescricaoReceita();
		this.categoriaReceita = receita.getCategoriaReceita();
		this.vencimentoReceita = receita.getVencimentoReceita();
		this.dataRecebimento = receita.getDataRecebimento();
	}
	
	public static List<ReceitaFormularioDto> converter(List<Receita> receitas) {
		
		return receitas.stream().map(ReceitaFormularioDto::new).collect(Collectors.toList());
	}

	public Long getCodigoReceita() {
		return codigoReceita;
	}
	
	public double getValorReceita() {
		return valorReceita;
	}
	
	public String getDescricaoReceita() {
		return descricaoReceita;
	}
	
	public String getCategoriaReceita() {
		return categoriaReceita;
	}
	
	public LocalDate getVencimentoReceita() {
		return vencimentoReceita;
	}
	
	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}
	

}
