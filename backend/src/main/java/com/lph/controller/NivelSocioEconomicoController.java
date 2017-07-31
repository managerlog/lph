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
import com.lph.database.imp.NivelSocioEconomicoDAO;
import com.lph.model.NivelSocioEconomico;

@Path("nivelSocioEconomico")
public class NivelSocioEconomicoController {
	
	private NivelSocioEconomicoDAO nDAO;
	
	public NivelSocioEconomicoController() {
		this.nDAO = new NivelSocioEconomicoDAO(NivelSocioEconomico.class);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<NivelSocioEconomico> getNiveis() {
		try {
			return nDAO.listAll();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NivelSocioEconomicoController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salvar/")
	public Response createNivelSocioEconomico(String json) {
		try {
			Gson gson = new Gson();
			NivelSocioEconomico n = gson.fromJson(json, NivelSocioEconomico.class);
			nDAO.save(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NivelSocioEconomicoController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
