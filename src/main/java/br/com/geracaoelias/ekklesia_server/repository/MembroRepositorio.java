package br.com.geracaoelias.ekklesia_server.repository;

import org.springframework.stereotype.Repository;

import com.cosium.spring.data.jpa.entity.graph.repository.JpaEntityGraphRepository;

import br.com.geracaoelias.ekklesia_server.model.Membro;

@Repository
public interface MembroRepositorio extends JpaEntityGraphRepository<Membro, Long> {	
	
}
