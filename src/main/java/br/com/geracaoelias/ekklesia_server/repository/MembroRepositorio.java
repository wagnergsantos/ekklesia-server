package br.com.geracaoelias.ekklesia_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geracaoelias.ekklesia_server.model.Membro;

@Repository()
public interface MembroRepositorio extends JpaRepository<Membro, Long> {	
	
}
