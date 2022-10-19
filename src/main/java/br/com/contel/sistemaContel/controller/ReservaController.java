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

import br.com.contel.sistemaContel.controller.dto.ReservaDto;
import br.com.contel.sistemaContel.controller.dto.ReservaFormularioDto;
import br.com.contel.sistemaContel.controller.form.ReservaCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarCancelarReservaForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarCheckInReservaForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarCheckOutReservaForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarReservaForm;
import br.com.contel.sistemaContel.model.Reserva;
import br.com.contel.sistemaContel.repository.HospedeRepository;
import br.com.contel.sistemaContel.repository.QuartoRepository;
import br.com.contel.sistemaContel.repository.ReservaRepository;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	
	@CrossOrigin
	@GetMapping("/{codigoReserva}")
	public ResponseEntity<ReservaFormularioDto> buscarReserva(@PathVariable Long codigoReserva) {
		
		return reservaRepository.findById(codigoReserva)
				.map(reserva -> ResponseEntity.ok().body(new ReservaFormularioDto(reserva)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@GetMapping("/mapa-de-reservas")
	public List<ReservaFormularioDto> buscarReservasFormulario(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
		
		if((dataInicial != null) && (dataFinal != null)) {
			List<Reserva> reservas = reservaRepository.findByDataCheckInReservaBetween(dataInicial, dataFinal);
			return ReservaFormularioDto.converter(reservas);
		}
		
		List<Reserva> reservas = reservaRepository.findAll();
		return ReservaFormularioDto.converter(reservas);	
	}
	
	
	@CrossOrigin
	@GetMapping("/painel-de-controle")
	public int buscarIndicadoresPainelDeControle(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCadastro,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCancelamento,	
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate qntHospedesDia) {
		
		
		if (dataCadastro != null) {
			List<Reserva> reservas = reservaRepository.findByDataCadastroReserva(dataCadastro);
			return reservas.size();
			
		} else if (dataCancelamento != null) {
			List<Reserva> reservas = reservaRepository.findByDataCancelamentoReserva(dataCancelamento);
			return reservas.size();
		}
		else if(qntHospedesDia != null) {
			int qntHospede = reservaRepository.findQntHospedes(qntHospedesDia); 
			return qntHospede; 
		}
		
		return 0;
	}
	@CrossOrigin
	@GetMapping("/diariaMedia/{diaSemana}/{dataAtual}") 
	public double diariaMedia(@PathVariable int diaSemana, @PathVariable String dataAtual) {
	
		double diariaMedia = reservaRepository.findDiariaMedia(diaSemana, dataAtual); 
		return diariaMedia; 
	}
	
	@CrossOrigin
	@GetMapping("/painel-de-controle/check")
	public List<ReservaFormularioDto> buscarReservasPainelDeControl(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataChegada, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataSaida){
		LocalDate dataFinal;
		
		if (dataChegada != null) {
			
			dataFinal = dataChegada.plusDays(5);
			List<Reserva> reservas = reservaRepository.findByDataCheckInReservaBetween(dataChegada,dataFinal);
			return ReservaFormularioDto.converter(reservas);
			
		} else if (dataSaida != null) {
			dataFinal = dataSaida.plusDays(5);
			List<Reserva> reservas = reservaRepository.findByDataCheckOutReservaBetween(dataSaida,dataFinal);
			return ReservaFormularioDto.converter(reservas);
		}
		
		else {
			List<Reserva> reservas = reservaRepository.findAll();
			return ReservaFormularioDto.converter(reservas);
		}
	}
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<ReservaDto> cadastrarReserva(@RequestBody @Valid ReservaCadastroForm reservaCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Reserva reserva = reservaCadastroForm.converter(hospedeRepository, quartoRepository);
		
		reservaRepository.save(reserva);
		
		URI uri = uriBuilder.path("/reserva/{codigoReserva}").buildAndExpand(reserva.getCodigoReserva()).toUri();
		return ResponseEntity.created(uri).body(new ReservaDto(reserva));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{codigoReserva}")
	public ResponseEntity<ReservaDto> atualizarReserva(@PathVariable Long codigoReserva, @RequestBody @Valid AtualizarReservaForm atualizarReservaForm) {
		
		Reserva reserva = atualizarReservaForm.atualizar(codigoReserva, reservaRepository, hospedeRepository, quartoRepository);
		
		return ResponseEntity.ok().body(new ReservaDto(reserva));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/check-in/{codigoReserva}")
	public ResponseEntity<ReservaDto> atualizarCheckInReserva(@PathVariable Long codigoReserva, @RequestBody @Valid AtualizarCheckInReservaForm atualizarCheckInReservaForm) {
		
		Reserva reserva = atualizarCheckInReservaForm.atualizar(codigoReserva, reservaRepository, quartoRepository);
		
		return ResponseEntity.ok().body(new ReservaDto(reserva));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/check-out/{codigoReserva}")
	public ResponseEntity<ReservaDto> atualizarCheckOutReserva(@PathVariable Long codigoReserva, @RequestBody @Valid AtualizarCheckOutReservaForm atualizarCheckOutReservaForm) {
		
		Reserva reserva = atualizarCheckOutReservaForm.atualizar(codigoReserva, reservaRepository, quartoRepository);
		
		return ResponseEntity.ok().body(new ReservaDto(reserva));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/cancelar/{codigoReserva}")
	public ResponseEntity<ReservaDto> atualizarCancelarReserva(@PathVariable Long codigoReserva, @RequestBody @Valid AtualizarCancelarReservaForm atualizarCancelarReservaForm) {
		
		Reserva reserva = atualizarCancelarReservaForm.atualizar(codigoReserva, reservaRepository);
		
		return ResponseEntity.ok().body(new ReservaDto(reserva));
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{codigoReserva}")
	public ResponseEntity<?> deletarReserva(@PathVariable Long codigoReserva) {
		
		Optional<Reserva> reservaOptional = reservaRepository.findById(codigoReserva);
		
		if(reservaOptional.isPresent()) {
			reservaRepository.deleteById(codigoReserva);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
}
