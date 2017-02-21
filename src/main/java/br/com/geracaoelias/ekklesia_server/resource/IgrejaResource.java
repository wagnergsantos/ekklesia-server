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

import br.com.geracaoelias.ekklesia_server.model.Estado;
import br.com.geracaoelias.ekklesia_server.model.Igreja;
import br.com.geracaoelias.ekklesia_server.repository.IgrejaRepositorio;

@Path("igrejas")
public class IgrejaResource {

	@Inject
	private IgrejaRepositorio igrejaRepositorio;

	@POST
	@Path("inicializar")
	@Transactional
	@Produces(MediaType.TEXT_HTML)
	public Response inicializar() {
		List<Igreja> salvar = new ArrayList<>();

		Igreja m1 = new Igreja();
		m1.setNome("aaaaa");
		m1.setEmail("a@email.com");
		m1.setEstado(Estado.ACRE);
		m1.setDirigente("aaaaaa");
		salvar.add(m1);

		Igreja m2 = new Igreja();
		m2.setNome("bbbbb");
		m2.setEmail("b@email.com");
		m2.setEstado(Estado.DISTRITOFEDERAL);
		m2.setDirigente("aaaaaa");
		salvar.add(m2);

		Igreja m3 = new Igreja();
		m3.setNome("cccc");
		m3.setEmail("c@email.com");
		m3.setDirigente("cccc");
		salvar.add(m3);

		Igreja m4 = new Igreja();
		m4.setNome("dddd");
		m4.setEmail("d@email.com");
		m4.setDirigente("dddd");
		salvar.add(m4);

		igrejaRepositorio.save(salvar);

		return Response.ok().build();
	}

	@GET
	@Produces( MediaType.APPLICATION_JSON)
	public Response listar() {
		List<Igreja> igrejas = igrejaRepositorio.findAll();
		GenericEntity<List<Igreja>> entity = new GenericEntity<List<Igreja>>(igrejas) {
		};
		return Response.status(200).entity(entity).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIgrejaById(@PathParam("id") Long id) {
		Igreja igreja = igrejaRepositorio.findOne(id);
		return Response.status(200).entity(igreja).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addIgreja(Igreja igreja) {
		Igreja igrejaT = igrejaRepositorio.save(igreja);
		return Response.status(200).entity(igrejaT).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateIgreja(Igreja igreja) {
		Igreja igrejaT = igrejaRepositorio.save(igreja);
		return Response.status(200).entity(igrejaT).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteIgreja(@PathParam("id") Long id) {
		igrejaRepositorio.delete(id);
		return Response.status(200).build();
	}

}
