package br.com.contel.sistemaContel.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.contel.sistemaContel.model.Diaria;
import br.com.contel.sistemaContel.model.Quarto;

public class QuartoFormularioDto {
	
	private String numeroQuarto;
	private int quantidadeCamaCasal;
	private int quantidadeCamaSolteiro;
	private Diaria diaria;	
	
	
	public QuartoFormularioDto(Quarto quarto) {
		this.numeroQuarto = quarto.getNumeroQuarto();
		this.quantidadeCamaCasal = quarto.getQuantidadeCamaCasal();
		this.quantidadeCamaSolteiro = quarto.getQuantidadeCamaSolteiro();
		this.diaria = quarto.getDiaria();
	}
	
	
	public static List<QuartoFormularioDto> converter(List<Quarto> quartos) {
		
		return quartos.stream().map(QuartoFormularioDto::new).collect(Collectors.toList());
	}
	

	public String getNumeroQuarto() {
		return numeroQuarto;
	}
	
	public int getQuantidadeCamaCasal() {
		return quantidadeCamaCasal;
	}
	
	public int getQuantidadeCamaSolteiro() {
		return quantidadeCamaSolteiro;
	}
	
	public Diaria getDiaria() {
		return diaria;
	}
	
	
}
