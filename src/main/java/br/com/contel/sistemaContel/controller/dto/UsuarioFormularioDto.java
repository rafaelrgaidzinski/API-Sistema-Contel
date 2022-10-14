package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Usuario;

public class UsuarioFormularioDto {

	private String loginUsuario;
	private String senhaUsuario;
	private String emailUsuario;
	private int telefoneUsuario;
	private String nomeUsuario;
	private String cargoUsuario;
	
	
	public UsuarioFormularioDto(Usuario usuario) {
		this.loginUsuario = usuario.getLoginUsuario();
		this.senhaUsuario = usuario.getSenhaUsuario();
		this.emailUsuario = usuario.getEmailUsuario();
		this.telefoneUsuario = usuario.getTelefoneUsuario();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.cargoUsuario = usuario.getCargoUsuario();
	}
	

	public String getLoginUsuario() {
		return loginUsuario;
	}
	
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	
	public int getTelefoneUsuario() {
		return telefoneUsuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public String getCargoUsuario() {
		return cargoUsuario;
	}
	
	
}
