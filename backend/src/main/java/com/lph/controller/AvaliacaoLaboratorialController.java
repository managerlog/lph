package com.lph.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.lph.database.imp.AvaliacaoLaboratorialDAO;
import com.lph.model.AvaliacaoLaboratorial;

@Path("avaliacoesLaboratoriais")
public class AvaliacaoLaboratorialController {
	
	private AvaliacaoLaboratorialDAO aDAO;
	
	public AvaliacaoLaboratorialController() {
		this.aDAO = new AvaliacaoLaboratorialDAO(AvaliacaoLaboratorial.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<AvaliacaoLaboratorial> getAvaliacoesLaboratoriais() {
		try {
			return aDAO.listAll();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(AvaliacaoLaboratorialController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salvar/")
	public Response createAvaliacaoLaboratorial(String json) {
		try {
			Gson gson = new Gson();
			AvaliacaoLaboratorial n = gson.fromJson(json, AvaliacaoLaboratorial.class);
			aDAO.save(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(AvaliacaoLaboratorialController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
