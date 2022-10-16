package br.com.contel.sistemaContel.controller.updateForm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.contel.sistemaContel.model.Usuario;
import br.com.contel.sistemaContel.repository.UsuarioRepository;

public class AtualizarUsuarioForm {
	
	@NotEmpty @NotBlank @Size(min = 6, max = 14)
	private String senhaUsuario;
	@NotEmpty @NotBlank @Email
	private String emailUsuario;
	private int telefoneUsuario;
	private String nomeUsuario;
	private String cargoUsuario;
	
	public Usuario atualizar(String loginUsuario, UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getReferenceById(loginUsuario);
		
		usuario.setSenhaUsuario(senhaUsuario);
		usuario.setEmailUsuario(emailUsuario);
		usuario.setTelefoneUsuario(telefoneUsuario);
		usuario.setNomeUsuario(nomeUsuario);
		usuario.setCargoUsuario(cargoUsuario);
		
		return usuario;
		
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
