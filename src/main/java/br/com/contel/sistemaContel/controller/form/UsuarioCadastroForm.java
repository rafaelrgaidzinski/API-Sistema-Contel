package br.com.contel.sistemaContel.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.contel.sistemaContel.model.Usuario;

public class UsuarioCadastroForm {
	
	@NotEmpty @NotBlank
	private String loginUsuario;
	@NotEmpty @NotBlank @Size(min = 6, max = 14)
	private String senhaUsuario;
	@NotEmpty @NotBlank @Email
	private String emailUsuario;
	private int telefoneUsuario;
	private String nomeUsuario;
	private String cargoUsuario;
	
	public Usuario converter() {
		
		return new Usuario(loginUsuario, senhaUsuario, emailUsuario, telefoneUsuario, nomeUsuario, cargoUsuario);
	}

	
	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(int telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCargoUsuario() {
		return cargoUsuario;
	}

	public void setCargoUsuario(String cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}
	

}
