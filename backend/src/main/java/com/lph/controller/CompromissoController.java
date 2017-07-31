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
import com.lph.database.imp.CompromissoDAO;
import com.lph.model.Compromisso;

@Path("compromissos")
public class CompromissoController {
	
	private CompromissoDAO cDAO;
	
	public CompromissoController() {
		this.cDAO = new CompromissoDAO(Compromisso.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Compromisso> getCompromissos() {
		try {
			return cDAO.listAll();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(CompromissoController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salvar/")
	public Response createCompromisso(String json) {
		try {
			Gson gson = new Gson();
			Compromisso n = gson.fromJson(json, Compromisso.class);
			cDAO.save(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(CompromissoController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
