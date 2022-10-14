package br.com.contel.sistemaContel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contel.sistemaContel.controller.dto.UsuarioLoginDto;
import br.com.contel.sistemaContel.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@CrossOrigin
	@GetMapping("/{loginUsuario}")
	public ResponseEntity<UsuarioLoginDto> loginUsuario(@PathVariable String loginUsuario) {
		
		return usuarioRepository.findById(loginUsuario)
				.map(usuario -> ResponseEntity.ok().body(new UsuarioLoginDto(usuario)))
				.orElse(ResponseEntity.notFound().build());
	}

}
