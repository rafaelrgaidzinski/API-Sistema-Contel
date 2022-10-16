package br.com.contel.sistemaContel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contel.sistemaContel.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
