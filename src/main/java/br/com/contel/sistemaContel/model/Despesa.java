package br.com.contel.sistemaContel.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoDespesa;
	private double valorDespesa;
	private String descricaoDespesa;
	private String categoriaDespesa;
	private LocalDate vencimentoDespesa;
	private LocalDate dataPagamento;
	
	// foreign key cnpjHotel
	
	
	public Despesa() {
		
	}
	
	public Despesa(int codigoDespesa, double valorDespesa, String descricaoDespesa, String categoriaDespesa,
			LocalDate vencimentoDespesa, LocalDate dataPagamento) {
		this.codigoDespesa = codigoDespesa;
		this.valorDespesa = valorDespesa;
		this.descricaoDespesa = descricaoDespesa;
		this.categoriaDespesa = categoriaDespesa;
		this.vencimentoDespesa = vencimentoDespesa;
		this.dataPagamento = dataPagamento;
	}


	public int getCodigoDespesa() {
		return codigoDespesa;
	}

	public void setCodigoDespesa(int codigoDespesa) {
		this.codigoDespesa = codigoDespesa;
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
