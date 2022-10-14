package br.com.contel.sistemaContel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diaria {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoDiaria;
	private String categoriaDiaria;
	private double valorDiariaSegunda;
	private double valorDiariaTerca;
	private double valorDiariaQuarta;
	private double valorDiariaQuinta;
	private double valorDiariaSexta;
	private double valorDiariaSabado;
	private double valorDiariaDomingo;
	
	// foreign key cnpjHotel
	
	
	public Diaria() {
		
	}
	
	public Diaria(int codigoDiaria, String categoriaDiaria, double valorDiariaSegunda, double valorDiariaTerca,
			double valorDiariaQuarta, double valorDiariaQuinta, double valorDiariaSexta, double valorDiariaSabado,
			double valorDiariaDomingo) {
		this.codigoDiaria = codigoDiaria;
		this.categoriaDiaria = categoriaDiaria;
		this.valorDiariaSegunda = valorDiariaSegunda;
		this.valorDiariaTerca = valorDiariaTerca;
		this.valorDiariaQuarta = valorDiariaQuarta;
		this.valorDiariaQuinta = valorDiariaQuinta;
		this.valorDiariaSexta = valorDiariaSexta;
		this.valorDiariaSabado = valorDiariaSabado;
		this.valorDiariaDomingo = valorDiariaDomingo;
	}
	
	
	public int getCodigoDiaria() {
		return codigoDiaria;
	}

	public void setCodigoDiaria(int codigoDiaria) {
		this.codigoDiaria = codigoDiaria;
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
