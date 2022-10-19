package br.com.contel.sistemaContel.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Reserva {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoReserva;
	private String situacaoReserva;
	private int quantidadeHospedes;
	private LocalDate dataCheckInReserva;
	private LocalDate dataCheckOutReserva;
	private String observacaoReserva;
	private LocalDate dataCadastroReserva;
	private LocalDate dataCancelamentoReserva;
	
	@ManyToOne
	private Quarto quarto;
	
	@ManyToOne
	private Hospede hospede;
	
	
	public Reserva() {
		
	}

	public Reserva(String situacaoReserva, int quantidadeHospedes, LocalDate dataCheckInReserva,
			LocalDate dataCheckOutReserva, String observacaoReserva, LocalDate dataCadastroReserva,
			LocalDate dataCancelamentoReserva, Quarto quarto, Hospede hospede) {
		this.situacaoReserva = situacaoReserva;
		this.quantidadeHospedes = quantidadeHospedes;
		this.dataCheckInReserva = dataCheckInReserva;
		this.dataCheckOutReserva = dataCheckOutReserva;
		this.observacaoReserva = observacaoReserva;
		this.dataCadastroReserva = dataCadastroReserva;
		this.dataCancelamentoReserva = dataCancelamentoReserva;
		this.quarto = quarto;
		this.hospede = hospede;
	}
	
	public Reserva(String situacaoReserva, int quantidadeHospedes, LocalDate dataCheckInReserva,
			LocalDate dataCheckOutReserva, String observacaoReserva, LocalDate dataCadastroReserva,
			Quarto quarto, Hospede hospede) {
		this.situacaoReserva = situacaoReserva;
		this.quantidadeHospedes = quantidadeHospedes;
		this.dataCheckInReserva = dataCheckInReserva;
		this.dataCheckOutReserva = dataCheckOutReserva;
		this.observacaoReserva = observacaoReserva;
		this.dataCadastroReserva = dataCadastroReserva;
		this.quarto = quarto;
		this.hospede = hospede;
	}


	public Long getCodigoReserva() {
		return codigoReserva;
	}


	public void setCodigoReserva(Long codigoReserva) {
		this.codigoReserva = codigoReserva;
	}


	public String getSituacaoReserva() {
		return situacaoReserva;
	}


	public void setSituacaoReserva(String situacaoReserva) {
		this.situacaoReserva = situacaoReserva;
	}


	public int getQuantidadeHospedes() {
		return quantidadeHospedes;
	}


	public void setQuantidadeHospedes(int quantidadeHospedes) {
		this.quantidadeHospedes = quantidadeHospedes;
	}


	public LocalDate getDataCheckInReserva() {
		return dataCheckInReserva;
	}


	public void setDataCheckInReserva(LocalDate dataCheckInReserva) {
		this.dataCheckInReserva = dataCheckInReserva;
	}


	public LocalDate getDataCheckOutReserva() {
		return dataCheckOutReserva;
	}


	public void setDataCheckOutReserva(LocalDate dataCheckOutReserva) {
		this.dataCheckOutReserva = dataCheckOutReserva;
	}


	public String getObservacaoReserva() {
		return observacaoReserva;
	}


	public void setObservacaoReserva(String observacaoReserva) {
		this.observacaoReserva = observacaoReserva;
	}


	public LocalDate getDataCadastroReserva() {
		return dataCadastroReserva;
	}


	public void setDataCadastroReserva(LocalDate dataCadastroReserva) {
		this.dataCadastroReserva = dataCadastroReserva;
	}


	public LocalDate getDataCancelamentoReserva() {
		return dataCancelamentoReserva;
	}


	public void setDataCancelamentoReserva(LocalDate dataCancelamentoReserva) {
		this.dataCancelamentoReserva = dataCancelamentoReserva;
	}


	public Quarto getQuarto() {
		return quarto;
	}


	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}


	public Hospede getHospede() {
		return hospede;
	}


	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}


}
