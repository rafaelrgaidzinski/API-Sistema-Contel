package br.com.contel.sistemaContel.controller.dto;

import br.com.contel.sistemaContel.model.Usuario;

public class UsuarioDto {

	private String loginUsuario;
	
	public UsuarioDto(Usuario usuario) {
		this.loginUsuario = usuario.getLoginUsuario();
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}
	
}
