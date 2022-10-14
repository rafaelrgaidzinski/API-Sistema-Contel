package br.com.contel.sistemaContel.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoReceita;
	private double valorReceita;
	private String descricaoReceita;
	private String categoriaReceita;
	private LocalDate vencimentoReceita;
	private LocalDate dataRecebimento;
	
	//foreign key codigoReserva
	//foreign key cnpjHotel
	
	
	public Receita() {
		
	}
	
	public Receita(int codigoReceita, double valorReceita, String descricaoReceita, String categoriaReceita,
			LocalDate vencimentoReceita, LocalDate dataRecebimento) {
		this.codigoReceita = codigoReceita;
		this.valorReceita = valorReceita;
		this.descricaoReceita = descricaoReceita;
		this.categoriaReceita = categoriaReceita;
		this.vencimentoReceita = vencimentoReceita;
		this.dataRecebimento = dataRecebimento;
	}


	public int getCodigoReceita() {
		return codigoReceita;
	}

	public void setCodigoReceita(int codigoReceita) {
		this.codigoReceita = codigoReceita;
	}

	public double getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(double valorReceita) {
		this.valorReceita = valorReceita;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public String getCategoriaReceita() {
		return categoriaReceita;
	}

	public void setCategoriaReceita(String categoriaReceita) {
		this.categoriaReceita = categoriaReceita;
	}

	public LocalDate getVencimentoReceita() {
		return vencimentoReceita;
	}

	public void setVencimentoReceita(LocalDate vencimentoReceita) {
		this.vencimentoReceita = vencimentoReceita;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	

}
