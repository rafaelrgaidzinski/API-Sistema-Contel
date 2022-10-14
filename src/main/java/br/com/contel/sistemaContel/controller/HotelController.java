package br.com.contel.sistemaContel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.contel.sistemaContel.controller.dto.HotelFormularioDto;
import br.com.contel.sistemaContel.repository.HotelRepository;

@RestController
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	@CrossOrigin
	@GetMapping("/cadastro-hotel/{cnpjHotel}")
	public ResponseEntity<HotelFormularioDto> buscarHotel(@PathVariable int cnpjHotel) {
		
		return hotelRepository.findById(cnpjHotel)
				.map(hotel -> ResponseEntity.ok().body(new HotelFormularioDto(hotel)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	

}
