package br.com.contel.sistemaContel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contel.sistemaContel.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
