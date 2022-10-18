package br.com.contel.sistemaContel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Quarto {
	
	@Id
	private String numeroQuarto;
	private int quantidadeCamaCasal;
	private int quantidadeCamaSolteiro;
	private boolean ocupado;
	
	@OneToOne
	private Diaria diaria;
	
	
	public Quarto() {
		
	}

	public Quarto(String numeroQuarto, int quantidadeCamaCasal, int quantidadeCamaSolteiro,
			Diaria diaria) {
		this.numeroQuarto = numeroQuarto;
		this.quantidadeCamaCasal = quantidadeCamaCasal;
		this.quantidadeCamaSolteiro = quantidadeCamaSolteiro;
		this.ocupado = false;
		this.diaria = diaria;
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

	public boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Diaria getDiaria() {
		return diaria;
	}

	public void setDiaria(Diaria diaria) {
		this.diaria = diaria;
	}
	
	
}
