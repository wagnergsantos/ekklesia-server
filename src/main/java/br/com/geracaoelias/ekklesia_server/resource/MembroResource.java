package br.com.geracaoelias.ekklesia_server.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.geracaoelias.ekklesia_server.model.Membro;
import br.com.geracaoelias.ekklesia_server.repository.MembroRepositorio;

@Component
@Path("membro")
@XmlRootElement
public class MembroResource  {

	@Inject	
	private MembroRepositorio membroRepositorio;
	
	@POST
	@Path("inicializar")
	@Transactional
	@Produces(MediaType.TEXT_HTML)
    public Response inicializar(){
	    List<Membro> salvar = new ArrayList<>();
	    
	    Membro m1 = new Membro();
	    m1.setNome("aaaaa");
	    m1.setEmail("a@email.com");	    
	    salvar.add(m1);
	    
	    Membro m2 = new Membro();
        m2.setNome("bbbbb");
        m2.setEmail("b@email.com");     
        salvar.add(m2);
        
        Membro m3 = new Membro();
        m3.setNome("cccc");
        m3.setEmail("c@email.com");     
        salvar.add(m3);
	    
	    membroRepositorio.save(salvar);
	    
	    return Response.ok().build();
    }
	
	@GET
    @Path("listar")
    public List<Membro> listar(){
        return membroRepositorio.findAll();
    }
}
