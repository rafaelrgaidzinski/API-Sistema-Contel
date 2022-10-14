package br.com.contel.sistemaContel.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Reserva {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoReserva;
	private String situacaoReserva;
	private int quantidadeHospedes;
	private LocalDate dataChegadaHospede;
	private LocalDate dataSaidaHospede;
	private String observacaoReserva;
	private LocalDate dataCheckInReserva;
	private LocalDate dataCheckOutReserva;
	private LocalDate dataCadastroReserva;
	private LocalDate dataCancelamentoReserva;
	
	//foreign key cpfHospede
	//foreign key codigoQuarto
	
	public Reserva() {
		
	}

	public Reserva(int codigoReserva, String situacaoReserva, int quantidadeHospedes, LocalDate dataChegadaHospede,
			LocalDate dataSaidaHospede, String observacaoReserva, LocalDate dataCheckInReserva,
			LocalDate dataCheckOutReserva, LocalDate dataCadastroReserva, LocalDate dataCancelamentoReserva) {
		this.codigoReserva = codigoReserva;
		this.situacaoReserva = situacaoReserva;
		this.quantidadeHospedes = quantidadeHospedes;
		this.dataChegadaHospede = dataChegadaHospede;
		this.dataSaidaHospede = dataSaidaHospede;
		this.observacaoReserva = observacaoReserva;
		this.dataCheckInReserva = dataCheckInReserva;
		this.dataCheckOutReserva = dataCheckOutReserva;
		this.dataCadastroReserva = dataCadastroReserva;
		this.dataCancelamentoReserva = dataCancelamentoReserva;
	}
	

	public int getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(int codigoReserva) {
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

	public LocalDate getDataChegadaHospede() {
		return dataChegadaHospede;
	}

	public void setDataChegadaHospede(LocalDate dataChegadaHospede) {
		this.dataChegadaHospede = dataChegadaHospede;
	}

	public LocalDate getDataSaidaHospede() {
		return dataSaidaHospede;
	}

	public void setDataSaidaHospede(LocalDate dataSaidaHospede) {
		this.dataSaidaHospede = dataSaidaHospede;
	}

	public String getObservacaoReserva() {
		return observacaoReserva;
	}

	public void setObservacaoReserva(String observacaoReserva) {
		this.observacaoReserva = observacaoReserva;
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


}
