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

import br.com.contel.sistemaContel.controller.dto.DespesaDto;
import br.com.contel.sistemaContel.controller.dto.DespesaFormularioDto;
import br.com.contel.sistemaContel.controller.form.DespesaCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarDataPagamentoForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarDespesaForm;
import br.com.contel.sistemaContel.model.Despesa;
import br.com.contel.sistemaContel.repository.DespesaRepository;

@RestController
@RequestMapping("/despesa")
public class DespesaController {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@CrossOrigin
	@GetMapping("/{codigoDespesa}")
	public ResponseEntity<DespesaFormularioDto> buscarDespesa(@PathVariable Long codigoDespesa) {
		
		return despesaRepository.findById(codigoDespesa)
				.map(despesa -> ResponseEntity.ok().body(new DespesaFormularioDto(despesa)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@GetMapping
	public List<DespesaFormularioDto> buscarDespesas(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		
		if((dataInicial != null) && (dataFinal != null)) {
			List<Despesa> despesas = despesaRepository.findByVencimentoDespesaBetween(dataInicial, dataFinal);
			return DespesaFormularioDto.converter(despesas);
		}
		
		List<Despesa> despesas = despesaRepository.findAll();
		return DespesaFormularioDto.converter(despesas);
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<DespesaDto> cadastrarDespesa(@RequestBody @Valid DespesaCadastroForm despesaCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Despesa despesa = despesaCadastroForm.converter();
		
		despesaRepository.save(despesa);
		
		URI uri = uriBuilder.path("/despesa/{codigoDespesa}").buildAndExpand(despesa.getCodigoDespesa()).toUri();
		return ResponseEntity.created(uri).body(new DespesaDto(despesa));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{codigoDespesa}")
	public ResponseEntity<DespesaDto> atualizarDespesa(@PathVariable Long codigoDespesa, @RequestBody @Valid AtualizarDespesaForm atualizarDespesaForm) {
		
		Despesa despesa = atualizarDespesaForm.atualizar(codigoDespesa, despesaRepository);
		
		return ResponseEntity.ok().body(new DespesaDto(despesa));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/pagamento/{codigoDespesa}")
	public ResponseEntity<DespesaDto> atualizarPagamentoDespesa(@PathVariable Long codigoDespesa, @RequestBody @Valid AtualizarDataPagamentoForm atualizarDataPagamentoForm) {
		
		Despesa despesa = atualizarDataPagamentoForm.atualizar(codigoDespesa, despesaRepository);
		
		return ResponseEntity.ok().body(new DespesaDto(despesa));
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{codigoDespesa}")
	public ResponseEntity<?> deletarDespesa(@PathVariable Long codigoDespesa) {
		
		Optional<Despesa> despesaOptional = despesaRepository.findById(codigoDespesa);
		
		if(despesaOptional.isPresent()) {
			despesaRepository.deleteById(codigoDespesa);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
