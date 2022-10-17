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

import br.com.contel.sistemaContel.controller.dto.HospedeDto;
import br.com.contel.sistemaContel.controller.dto.HospedeFormularioDto;
import br.com.contel.sistemaContel.controller.form.HospedeCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarHospedeForm;
import br.com.contel.sistemaContel.model.Hospede;
import br.com.contel.sistemaContel.repository.EnderecoRepository;
import br.com.contel.sistemaContel.repository.HospedeRepository;

@RestController
@RequestMapping("/hospede")
public class HospedeController {
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	
	@CrossOrigin
	@GetMapping("/{cpfHospede}")
	public ResponseEntity<HospedeFormularioDto> buscarHospede(@PathVariable Long cpfHospede) {
		
		return hospedeRepository.findById(cpfHospede)
				.map(hospede -> ResponseEntity.ok().body(new HospedeFormularioDto(hospede)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<HospedeDto> cadastrarHospede(@RequestBody @Valid HospedeCadastroForm hospedeCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Hospede hospede = hospedeCadastroForm.converter(enderecoRepository);
		
		hospedeRepository.save(hospede);
		
		URI uri = uriBuilder.path("/hospede/{cpfHospede}").buildAndExpand(hospede.getCpfHospede()).toUri();
		return ResponseEntity.created(uri).body(new HospedeDto(hospede));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{cpfHospede}")
	public ResponseEntity<HospedeDto> atualizarHospede(@PathVariable Long cpfHospede, @RequestBody @Valid AtualizarHospedeForm atualizarHospedeForm) {
		
		Hospede hospede = atualizarHospedeForm.atualizar(cpfHospede, hospedeRepository, enderecoRepository);
		
		return ResponseEntity.ok().body(new HospedeDto(hospede));
		
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{cpfHospede}")
	public ResponseEntity<?> deletarHospede(@PathVariable Long cpfHospede) {
		
		Optional<Hospede> hospedeOptional = hospedeRepository.findById(cpfHospede);
		
		if(hospedeOptional.isPresent()) {
			hospedeRepository.deleteById(cpfHospede);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
