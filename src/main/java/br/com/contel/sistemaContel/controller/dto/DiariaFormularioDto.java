package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Diaria;
import java.util.List;
import java.util.stream.Collectors;

public class DiariaFormularioDto {
	
	private int codigoDiaria;
	private String categoriaDiaria;
	private double valorDiariaSegunda;
	private double valorDiariaTerca;
	private double valorDiariaQuarta;
	private double valorDiariaQuinta;
	private double valorDiariaSexta;
	private double valorDiariaSabado;
	private double valorDiariaDomingo;
	
	
	public DiariaFormularioDto(Diaria diaria) {
		this.codigoDiaria = diaria.getCodigoDiaria();
		this.categoriaDiaria = diaria.getCategoriaDiaria();
		this.valorDiariaSegunda = diaria.getValorDiariaSegunda();
		this.valorDiariaTerca = diaria.getValorDiariaTerca();
		this.valorDiariaQuarta = diaria.getValorDiariaQuarta();
		this.valorDiariaQuinta = diaria.getValorDiariaQuinta();
		this.valorDiariaSexta = diaria.getValorDiariaSexta();
		this.valorDiariaSabado = diaria.getValorDiariaSabado();
		this.valorDiariaDomingo = diaria.getValorDiariaDomingo();
	}
	
	public static List<DiariaFormularioDto> converter(List<Diaria> diarias) {
		
		return diarias.stream().map(DiariaFormularioDto::new).collect(Collectors.toList());
	}

	
	public int getCodigoDiaria() {
		return codigoDiaria;
	}
	
	public String getCategoriaDiaria() {
		return categoriaDiaria;
	}
	
	public double getValorDiariaSegunda() {
		return valorDiariaSegunda;
	}
	
	public double getValorDiariaTerca() {
		return valorDiariaTerca;
	}
	
	public double getValorDiariaQuarta() {
		return valorDiariaQuarta;
	}
	
	public double getValorDiariaQuinta() {
		return valorDiariaQuinta;
	}
	
	public double getValorDiariaSexta() {
		return valorDiariaSexta;
	}
	
	public double getValorDiariaSabado() {
		return valorDiariaSabado;
	}
	
	public double getValorDiariaDomingo() {
		return valorDiariaDomingo;
	}
	
	
}
