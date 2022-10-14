package br.com.contel.sistemaContel.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private String loginUsuario;
	private String senhaUsuario;
	private String emailUsuario;
	private int telefoneUsuario;
	private String nomeUsuario;
	private String cargoUsuario;
	
	
	public Usuario() {
		
	}

	public Usuario(String loginUsuario, String senhaUsuario, String emailUsuario, int telefoneUsuario,
			String nomeUsuario, String cargoUsuario) {
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.emailUsuario = emailUsuario;
		this.telefoneUsuario = telefoneUsuario;
		this.nomeUsuario = nomeUsuario;
		this.cargoUsuario = cargoUsuario;
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
