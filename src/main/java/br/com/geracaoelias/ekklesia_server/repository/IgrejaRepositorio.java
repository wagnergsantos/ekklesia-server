package br.com.geracaoelias.ekklesia_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geracaoelias.ekklesia_server.model.Igreja;

@Repository
public interface IgrejaRepositorio extends JpaRepository<Igreja, Long> {	
    Igreja findByNomeContainingIgnoreCase(String nome);		
}
