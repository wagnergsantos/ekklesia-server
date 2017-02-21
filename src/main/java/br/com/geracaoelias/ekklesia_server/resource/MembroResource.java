package br.com.geracaoelias.ekklesia_server.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.transaction.annotation.Transactional;

import br.com.geracaoelias.ekklesia_server.model.Cargo;
import br.com.geracaoelias.ekklesia_server.model.Estado;
import br.com.geracaoelias.ekklesia_server.model.EstadoCivil;
import br.com.geracaoelias.ekklesia_server.model.Igreja;
import br.com.geracaoelias.ekklesia_server.model.Membro;
import br.com.geracaoelias.ekklesia_server.repository.IgrejaRepositorio;
import br.com.geracaoelias.ekklesia_server.repository.MembroRepositorio;

@Path("membros")
public class MembroResource {

	@Inject
	private MembroRepositorio membroRepositorio;
	
	@Inject
    private IgrejaRepositorio igrejaRepositorio;

	@POST
	@Path("inicializar")
	@Transactional
	@Produces(MediaType.TEXT_HTML)
	public Response inicializar() {
		List<Membro> salvar = new ArrayList<>();
		
		Igreja i1 = igrejaRepositorio.findByNomeContainingIgnoreCase("aaa");

		Membro m1 = new Membro();
		m1.setNome("aaaaa");
		m1.setEmail("a@email.com");
		m1.setEstado(Estado.ACRE);
		m1.setEstadoCivil(EstadoCivil.CASADO);
		m1.setCargo(Cargo.DIACONO);
		m1.setIgreja(i1);
		salvar.add(m1);

		Membro m2 = new Membro();
		m2.setNome("bbbbb");
		m2.setEmail("b@email.com");
		m2.setEstado(Estado.DISTRITOFEDERAL);
		m2.setEstadoCivil(EstadoCivil.CASADO);
		m2.setCargo(Cargo.EVANGELISTA);
		m2.setIgreja(i1);
		salvar.add(m2);

		Membro m3 = new Membro();
		m3.setNome("cccc");
		m3.setEmail("c@email.com");
		m3.setEstadoCivil(EstadoCivil.SOLTERO);
		m3.setCargo(Cargo.MISSIONARIO);
		m3.setIgreja(i1);
		salvar.add(m3);

		Membro m4 = new Membro();
		m4.setNome("dddd");
		m4.setEmail("d@email.com");
		m4.setEstadoCivil(EstadoCivil.VIUVO);
		m4.setCargo(Cargo.PASTOR);
		m4.setIgreja(i1);
		salvar.add(m4);

		membroRepositorio.save(salvar);

		return Response.ok().build();
	}

	@GET
	@Produces( MediaType.APPLICATION_JSON)
	public Response listar() {
		List<Membro> membros = membroRepositorio.findAll();
		GenericEntity<List<Membro>> entity = new GenericEntity<List<Membro>>(membros) {
		};
		return Response.status(200).entity(entity).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMembroById(@PathParam("id") Long id) {
		Membro membro = membroRepositorio.findOne(id);
		return Response.status(200).entity(membro).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMembro(Membro membro) {
		Membro membroT = membroRepositorio.save(membro);
		return Response.status(200).entity(membroT).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateMembro(Membro membro) {
		Membro membroT = membroRepositorio.save(membro);
		return Response.status(200).entity(membroT).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMembro(@PathParam("id") Long id) {
		membroRepositorio.delete(id);
		return Response.status(200).build();
	}

}
