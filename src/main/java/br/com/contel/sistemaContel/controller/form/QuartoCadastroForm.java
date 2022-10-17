package br.com.contel.sistemaContel.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.contel.sistemaContel.model.Diaria;
import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.repository.DiariaRepository;

public class QuartoCadastroForm {

	@NotEmpty 
	private String numeroQuarto;
	@NotNull @PositiveOrZero
	private int quantidadeCamaCasal;
	@NotNull @PositiveOrZero
	private int quantidadeCamaSolteiro;
	
	@NotNull
	private int codigoDiaria;
	
	
	public Quarto converter(DiariaRepository diariaRepository) {
		
		Diaria diaria = diariaRepository.getReferenceById(codigoDiaria);
		
		return new Quarto(numeroQuarto, quantidadeCamaCasal, quantidadeCamaSolteiro, diaria);
	}
	

	public String getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getQuantidadeCamaCasal() {
		return quantidadeCamaCasal;
	}

	public void setQuantidadeCamaCasal(int quantidadeCamaCasal) {
		this.quantidadeCamaCasal = quantidadeCamaCasal;
	}

	public int getQuantidadeCamaSolteiro() {
		return quantidadeCamaSolteiro;
	}

	public void setQuantidadeCamaSolteiro(int quantidadeCamaSolteiro) {
		this.quantidadeCamaSolteiro = quantidadeCamaSolteiro;
	}

	public int getCodigoDiaria() {
		return codigoDiaria;
	}

	public void setCodigoDiaria(int codigoDiaria) {
		this.codigoDiaria = codigoDiaria;
	}
	
	
}
