package br.com.contel.sistemaContel.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.contel.sistemaContel.model.Receita;
import br.com.contel.sistemaContel.model.Reserva;
import br.com.contel.sistemaContel.repository.ReservaRepository;

public class ReceitaCadastroForm {

	@NotNull @PositiveOrZero
	private double valorReceita;
	private String descricaoReceita;
	@NotEmpty
	private String categoriaReceita;
	@NotNull @FutureOrPresent
	private LocalDate vencimentoReceita;
	@FutureOrPresent
	private LocalDate dataRecebimento;
	
	private Long codigoReserva;
	
	
	public Receita converter(ReservaRepository reservaRepository) {
		
		if(codigoReserva != null) {
			Reserva reserva = reservaRepository.getReferenceById(codigoReserva);
			return new Receita(valorReceita, descricaoReceita, categoriaReceita, vencimentoReceita, dataRecebimento, reserva);
		}
		
		return new Receita(valorReceita, descricaoReceita, categoriaReceita, vencimentoReceita, dataRecebimento);
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

	public Long getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(Long codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	
	
}
