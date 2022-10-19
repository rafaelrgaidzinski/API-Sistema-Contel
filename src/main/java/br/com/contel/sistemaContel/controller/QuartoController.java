package br.com.contel.sistemaContel.controller;

import java.net.URI;
import java.util.List;
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

import br.com.contel.sistemaContel.controller.dto.QuartoDto;
import br.com.contel.sistemaContel.controller.dto.QuartoFormularioDto;
import br.com.contel.sistemaContel.controller.form.QuartoCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarQuartoForm;
import br.com.contel.sistemaContel.model.Quarto;
import br.com.contel.sistemaContel.repository.DiariaRepository;
import br.com.contel.sistemaContel.repository.QuartoRepository;

@RestController
@RequestMapping("/quarto")
public class QuartoController {
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@Autowired
	private DiariaRepository diariaRepository;
	
	
	@CrossOrigin
	@GetMapping("/{numeroQuarto}")
	public ResponseEntity<QuartoFormularioDto> buscarQuarto(@PathVariable String numeroQuarto) {
		
		return quartoRepository.findById(numeroQuarto)
				.map(quarto -> ResponseEntity.ok().body(new QuartoFormularioDto(quarto)))
				.orElse(ResponseEntity.notFound().build());	
	}

	
	@CrossOrigin
	@GetMapping
	public List<QuartoFormularioDto> buscarQuartos() {
		
		List<Quarto> quartos = quartoRepository.findAll();	
		return QuartoFormularioDto.converter(quartos);
	}
	
	@CrossOrigin
	@GetMapping("/capacidadeHotel") 
	public int detalharSaida() {
		int qntHospedes = quartoRepository.findQntHospedeQuarto(); 
		return qntHospedes; 
	}
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<QuartoDto> cadastrarQuarto(@RequestBody @Valid QuartoCadastroForm quartoCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Quarto quarto = quartoCadastroForm.converter(diariaRepository);
		
		quartoRepository.save(quarto);
		
		URI uri = uriBuilder.path("/quarto/{numeroQuarto}").buildAndExpand(quarto.getNumeroQuarto()).toUri();
		return ResponseEntity.created(uri).body(new QuartoDto(quarto));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{numeroQuarto}")
	public ResponseEntity<QuartoDto> atualizarQuarto(@PathVariable String numeroQuarto, @RequestBody @Valid AtualizarQuartoForm atualizarQuartoForm) {
		
		Quarto quarto = atualizarQuartoForm.atualizar(numeroQuarto, quartoRepository, diariaRepository);
		
		return ResponseEntity.ok().body(new QuartoDto(quarto));
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{numeroQuarto}")
	public ResponseEntity<?> deletarQuarto(@PathVariable String numeroQuarto) {
		
		Optional<Quarto> quartoOptional = quartoRepository.findById(numeroQuarto);
		
		if(quartoOptional.isPresent()) {
			quartoRepository.deleteById(numeroQuarto);
			ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
