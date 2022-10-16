package br.com.contel.sistemaContel.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.contel.sistemaContel.controller.dto.DiariaDto;
import br.com.contel.sistemaContel.controller.dto.DiariaFormularioDto;
import br.com.contel.sistemaContel.controller.form.DiariaCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarDiariaForm;
import br.com.contel.sistemaContel.model.Diaria;
import br.com.contel.sistemaContel.repository.DiariaRepository;

@RestController
@RequestMapping("/diaria")
public class DiariaController {

	@Autowired
	private DiariaRepository diariaRepository;
	
	
	@CrossOrigin
	@GetMapping
	public List<DiariaFormularioDto> buscarDiarias() {
		
		List<Diaria> diarias = diariaRepository.findAll();
		
		return DiariaFormularioDto.converter(diarias);
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<DiariaDto> cadastrarDiaria(@RequestBody @Valid DiariaCadastroForm diariaCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Diaria diaria = diariaCadastroForm.converter();
		
		diariaRepository.save(diaria);
		
		URI uri = uriBuilder.path("/diaria/{codigoDiaria}").buildAndExpand(diaria.getCodigoDiaria()).toUri();
		return ResponseEntity.created(uri).body(new DiariaDto(diaria));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{codigoDiaria}")
	public ResponseEntity<DiariaDto> atualizarDiaria(@PathVariable int codigoDiaria, @RequestBody @Valid AtualizarDiariaForm atualizarDiariaForm) {
		
		Diaria diaria = atualizarDiariaForm.atualizar(codigoDiaria, diariaRepository);
		
		return ResponseEntity.ok().body(new DiariaDto(diaria));

	}
	
	
}
