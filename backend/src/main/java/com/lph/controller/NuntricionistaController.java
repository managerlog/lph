package com.lph.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lph.database.imp.NutricionistaDAO;
import com.lph.model.Nutricionista;

@Path("nutricionistas")
public class NuntricionistaController {
	
	private NutricionistaDAO nDAO;
	
	public NuntricionistaController() {
		this.nDAO = new NutricionistaDAO(Nutricionista.class);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Nutricionista getNutricionista(@PathParam("id") long id) {
		try {
			return nDAO.get(id);
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NuntricionistaController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Nutricionista> getNutricionistas() {
		try {
			return nDAO.listAll();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NuntricionistaController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response createNutricionista(Nutricionista n) {
		try {
			nDAO.save(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NuntricionistaController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response updateNutricionia(Nutricionista n) {
		try {
			nDAO.update(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NuntricionistaController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response deleteNuticionista(Nutricionista n) {
		try {
			nDAO.delete(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(NuntricionistaController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
