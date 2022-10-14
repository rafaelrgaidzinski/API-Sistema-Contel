package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Usuario;

public class UsuarioLoginDto {
	
	private String loginUsuario;
	private String senhaUsuario;
	
	public UsuarioLoginDto(Usuario usuario) {
		this.loginUsuario = usuario.getLoginUsuario();
		this.senhaUsuario = usuario.getSenhaUsuario();
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}
	
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	
}
