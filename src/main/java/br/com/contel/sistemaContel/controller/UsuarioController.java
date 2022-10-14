package br.com.contel.sistemaContel.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.contel.sistemaContel.controller.dto.UsuarioDto;
import br.com.contel.sistemaContel.controller.dto.UsuarioFormularioDto;
import br.com.contel.sistemaContel.controller.form.UsuarioCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarUsuarioForm;
import br.com.contel.sistemaContel.model.Usuario;
import br.com.contel.sistemaContel.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@CrossOrigin
	@GetMapping("/{loginUsuario}")
	public ResponseEntity<UsuarioFormularioDto> buscarUsuario(@PathVariable String loginUsuario) {
		
		return usuarioRepository.findById(loginUsuario)
				.map(usuario -> ResponseEntity.ok().body(new UsuarioFormularioDto(usuario)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody @Valid UsuarioCadastroForm usuarioCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = usuarioCadastroForm.converter();
		
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuario/{loginUsuario}").buildAndExpand(usuario.getLoginUsuario()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{loginUsuario}")
	public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable String loginUsuario, @RequestBody @Valid AtualizarUsuarioForm atualizarUsuarioForm) {
		
		Usuario usuario = atualizarUsuarioForm.atualizar(loginUsuario, usuarioRepository);
		
		return ResponseEntity.ok().body(new UsuarioDto(usuario));
		
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{loginUsuario}")
	public ResponseEntity<UsuarioDto> deletarUsuario(@PathVariable String loginUsuario) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(loginUsuario);
		
		if(usuarioOptional.isPresent()) {
			usuarioRepository.deleteById(loginUsuario);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
