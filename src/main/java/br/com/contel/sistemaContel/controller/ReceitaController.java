package br.com.contel.sistemaContel.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import br.com.contel.sistemaContel.controller.dto.ReceitaDto;
import br.com.contel.sistemaContel.controller.dto.ReceitaFormularioDto;
import br.com.contel.sistemaContel.controller.form.ReceitaCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarDataRecebimentoForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarReceitaForm;
import br.com.contel.sistemaContel.model.Receita;
import br.com.contel.sistemaContel.repository.ReceitaRepository;
import br.com.contel.sistemaContel.repository.ReservaRepository;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	@CrossOrigin
	@GetMapping("/{codigoReceita}")
	public ResponseEntity<ReceitaFormularioDto> buscarReceita(@PathVariable Long codigoReceita) {
		
		return receitaRepository.findById(codigoReceita)
				.map(receita -> ResponseEntity.ok().body(new ReceitaFormularioDto(receita)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@GetMapping
	public List<ReceitaFormularioDto> buscarReceitas(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		
		if((dataInicial != null) && (dataFinal != null)) {
			List<Receita> receitas = receitaRepository.findByVencimentoReceitaBetween(dataInicial, dataFinal);
			return ReceitaFormularioDto.converter(receitas);
		}
		
		List<Receita> receitas = receitaRepository.findAll();
		return ReceitaFormularioDto.converter(receitas);
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<ReceitaDto> cadastrarReceita(@RequestBody @Valid ReceitaCadastroForm receitaCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Receita receita = receitaCadastroForm.converter(reservaRepository);
		
		receitaRepository.save(receita);
		
		URI uri = uriBuilder.path("/receita/{codigoReceita}").buildAndExpand(receita.getCodigoReceita()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{codigoReceita}")
	public ResponseEntity<ReceitaDto> atualizarReceita(@PathVariable Long codigoReceita, @RequestBody @Valid AtualizarReceitaForm atualizarReceitaForm) {
		
		Receita receita = atualizarReceitaForm.atualizar(codigoReceita, receitaRepository);
		
		return ResponseEntity.ok().body(new ReceitaDto(receita));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/recebimento/{codigoReceita}")
	public ResponseEntity<ReceitaDto> atualizarReceita(@PathVariable Long codigoReceita, @RequestBody @Valid AtualizarDataRecebimentoForm atualizarDataRecebimentoForm) {
		
		Receita receita = atualizarDataRecebimentoForm.atualizar(codigoReceita, receitaRepository);
		
		return ResponseEntity.ok().body(new ReceitaDto(receita));
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{codigoReceita}")
	public ResponseEntity<?> deletarReceita(@PathVariable Long codigoReceita) {
		
		Optional<Receita> receitaOptional = receitaRepository.findById(codigoReceita);
		
		if(receitaOptional.isPresent()) {
			receitaRepository.deleteById(codigoReceita);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	
}
