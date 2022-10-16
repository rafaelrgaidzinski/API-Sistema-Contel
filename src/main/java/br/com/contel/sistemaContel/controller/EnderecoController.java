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

import br.com.contel.sistemaContel.controller.dto.EnderecoDto;
import br.com.contel.sistemaContel.controller.dto.EnderecoFormularioDto;
import br.com.contel.sistemaContel.controller.form.EnderecoCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarEnderecoForm;
import br.com.contel.sistemaContel.model.Endereco;
import br.com.contel.sistemaContel.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@CrossOrigin
	@GetMapping("/{codigoEndereco}")
	public ResponseEntity<EnderecoFormularioDto> buscarEndereco(@PathVariable int codigoEndereco) {
		
		return enderecoRepository.findById(codigoEndereco)
				.map(endereco -> ResponseEntity.ok().body(new EnderecoFormularioDto(endereco)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<EnderecoDto> cadastrarEndereco(@RequestBody @Valid EnderecoCadastroForm enderecoCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Endereco endereco = enderecoCadastroForm.converter();
		
		enderecoRepository.save(endereco);
		
		URI uri = uriBuilder.path("/endereco/{codigoEndereco}").buildAndExpand(endereco.getCodigoEndereco()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{codigoEndereco}")
	public ResponseEntity<EnderecoDto> atualizarEndereco(@PathVariable int codigoEndereco, @RequestBody @Valid AtualizarEnderecoForm atualizarEnderecoForm) {
		
		Endereco endereco = atualizarEnderecoForm.atualizar(codigoEndereco, enderecoRepository);
		
		return ResponseEntity.ok().body(new EnderecoDto(endereco));
		
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{codigoEndereco}")
	public ResponseEntity<?> deletarEndereco(@PathVariable int codigoEndereco) {
		
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(codigoEndereco);
		
		if(enderecoOptional.isPresent()) {
			enderecoRepository.deleteById(codigoEndereco);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
