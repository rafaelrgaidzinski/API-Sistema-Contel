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

import br.com.contel.sistemaContel.controller.dto.HotelDto;
import br.com.contel.sistemaContel.controller.dto.HotelFormularioDto;
import br.com.contel.sistemaContel.controller.form.HotelCadastroForm;
import br.com.contel.sistemaContel.controller.updateForm.AtualizarHotelForm;
import br.com.contel.sistemaContel.model.Hotel;
import br.com.contel.sistemaContel.repository.EnderecoRepository;
import br.com.contel.sistemaContel.repository.HotelRepository;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@CrossOrigin
	@GetMapping("/{cnpjHotel}")
	public ResponseEntity<HotelFormularioDto> buscarHotel(@PathVariable Long cnpjHotel) {
		
		return hotelRepository.findById(cnpjHotel)
				.map(hotel -> ResponseEntity.ok().body(new HotelFormularioDto(hotel)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<HotelDto> cadastrarHotel(@RequestBody @Valid HotelCadastroForm hotelCadastroForm, UriComponentsBuilder uriBuilder) {
		
		Hotel hotel = hotelCadastroForm.converter(enderecoRepository);
		
		hotelRepository.save(hotel);
		
		URI uri = uriBuilder.path("/hotel/{cnpjHotel}").buildAndExpand(hotel.getCnpjHotel()).toUri();
		return ResponseEntity.created(uri).body(new HotelDto(hotel));
	}
	
	
	@CrossOrigin
	@Transactional
	@PutMapping("/{cnpjHotel}")
	public ResponseEntity<HotelDto> atualizarHotel(@PathVariable Long cnpjHotel, @RequestBody @Valid AtualizarHotelForm atualizarHotelForm) {
		
		Hotel hotel = atualizarHotelForm.atualizar(cnpjHotel, hotelRepository, enderecoRepository);
		
		return ResponseEntity.ok().body(new HotelDto(hotel));
	}
	
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("/{cnpjHotel}")
	public ResponseEntity<?> deletarHotel(@PathVariable Long cnpjHotel) {
		
		Optional<Hotel> hotelOptional = hotelRepository.findById(cnpjHotel);
		
		if(hotelOptional.isPresent()) {
			hotelRepository.deleteById(cnpjHotel);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
		
	}
	

}
