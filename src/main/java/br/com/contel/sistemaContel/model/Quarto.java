package br.com.contel.sistemaContel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quarto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoQuarto;
	private String numeroQuarto;
	private int quantidadeCamaCasal;
	private int quantidadeCamaSolteiro;
	
	// foreign key codigoDiaria
	
	
	public Quarto() {
		
	}

	public Quarto(int codigoQuarto, String numeroQuarto, int quantidadeCamaCasal, int quantidadeCamaSolteiro) {
		this.codigoQuarto = codigoQuarto;
		this.numeroQuarto = numeroQuarto;
		this.quantidadeCamaCasal = quantidadeCamaCasal;
		this.quantidadeCamaSolteiro = quantidadeCamaSolteiro;
	}
	

	public int getCodigoQuarto() {
		return codigoQuarto;
	}

	public void setCodigoQuarto(int codigoQuarto) {
		this.codigoQuarto = codigoQuarto;
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
	
	
}
