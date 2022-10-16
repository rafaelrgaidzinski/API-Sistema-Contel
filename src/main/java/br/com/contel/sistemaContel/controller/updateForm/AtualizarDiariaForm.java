package br.com.contel.sistemaContel.controller.updateForm;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.contel.sistemaContel.model.Diaria;
import br.com.contel.sistemaContel.repository.DiariaRepository;

public class AtualizarDiariaForm {
	
	@NotEmpty
	private String categoriaDiaria;
	@NotNull @Positive
	private double valorDiariaSegunda;
	@NotNull @Positive
	private double valorDiariaTerca;
	@NotNull @Positive
	private double valorDiariaQuarta;
	@NotNull @Positive
	private double valorDiariaQuinta;
	@NotNull @Positive
	private double valorDiariaSexta;
	@NotNull @Positive
	private double valorDiariaSabado;
	@NotNull @Positive
	private double valorDiariaDomingo;
	
	
	public Diaria atualizar(int codigoDiaria, DiariaRepository diariaRepository) {
		
		Diaria diaria = diariaRepository.getReferenceById(codigoDiaria);
		
		diaria.setCategoriaDiaria(categoriaDiaria);
		diaria.setValorDiariaSegunda(valorDiariaSegunda);
		diaria.setValorDiariaTerca(valorDiariaTerca);
		diaria.setValorDiariaQuarta(valorDiariaQuarta);
		diaria.setValorDiariaQuinta(valorDiariaQuinta);
		diaria.setValorDiariaSexta(valorDiariaSexta);
		diaria.setValorDiariaSabado(valorDiariaSabado);
		diaria.setValorDiariaDomingo(valorDiariaDomingo);
		
		return diaria;
	}
	
	
	public String getCategoriaDiaria() {
		return categoriaDiaria;
	}
	
	public void setCategoriaDiaria(String categoriaDiaria) {
		this.categoriaDiaria = categoriaDiaria;
	}
	
	public double getValorDiariaSegunda() {
		return valorDiariaSegunda;
	}
	
	public void setValorDiariaSegunda(double valorDiariaSegunda) {
		this.valorDiariaSegunda = valorDiariaSegunda;
	}
	
	public double getValorDiariaTerca() {
		return valorDiariaTerca;
	}
	
	public void setValorDiariaTerca(double valorDiariaTerca) {
		this.valorDiariaTerca = valorDiariaTerca;
	}
	
	public double getValorDiariaQuarta() {
		return valorDiariaQuarta;
	}
	
	public void setValorDiariaQuarta(double valorDiariaQuarta) {
		this.valorDiariaQuarta = valorDiariaQuarta;
	}
	
	public double getValorDiariaQuinta() {
		return valorDiariaQuinta;
	}
	
	public void setValorDiariaQuinta(double valorDiariaQuinta) {
		this.valorDiariaQuinta = valorDiariaQuinta;
	}
	
	public double getValorDiariaSexta() {
		return valorDiariaSexta;
	}
	
	public void setValorDiariaSexta(double valorDiariaSexta) {
		this.valorDiariaSexta = valorDiariaSexta;
	}
	
	public double getValorDiariaSabado() {
		return valorDiariaSabado;
	}
	
	public void setValorDiariaSabado(double valorDiariaSabado) {
		this.valorDiariaSabado = valorDiariaSabado;
	}
	
	public double getValorDiariaDomingo() {
		return valorDiariaDomingo;
	}
	
	public void setValorDiariaDomingo(double valorDiariaDomingo) {
		this.valorDiariaDomingo = valorDiariaDomingo;
	}
	

}
