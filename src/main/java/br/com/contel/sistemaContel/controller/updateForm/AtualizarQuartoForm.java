package br.com.contel.sistemaContel.controller.updateForm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.contel.sistemaContel.model.Diaria;
import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.repository.DiariaRepository;
import br.com.contel.sistemaContel.repository.QuartoRepository;

public class AtualizarQuartoForm {
	
	@NotNull @PositiveOrZero
	private int quantidadeCamaCasal;
	@NotNull @PositiveOrZero
	private int quantidadeCamaSolteiro;
	
	@NotNull
	private int codigoDiaria;

	
	public Quarto atualizar(String numeroQuarto, QuartoRepository quartoRepository, DiariaRepository diariaRepository) {
		
		Quarto quarto = quartoRepository.getReferenceById(numeroQuarto);
		Diaria diaria = diariaRepository.getReferenceById(codigoDiaria);
		
		quarto.setQuantidadeCamaCasal(quantidadeCamaCasal);
		quarto.setQuantidadeCamaSolteiro(quantidadeCamaSolteiro);
		quarto.setDiaria(diaria);
		
		return quarto;
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
