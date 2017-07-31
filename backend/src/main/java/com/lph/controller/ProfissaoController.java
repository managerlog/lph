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
import com.lph.database.imp.ProfissaoDAO;
import com.lph.model.Profissao;

@Path("profissoes")
public class ProfissaoController {
	
	private ProfissaoDAO pDAO;
	
	public ProfissaoController() {
		this.pDAO = new ProfissaoDAO(Profissao.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Profissao> getProfissoes() {
		try {
			return pDAO.listAll();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(ProfissaoController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salvar/")
	public Response createProfissao(String json) {
		try {
			Gson gson = new Gson();
			Profissao n = gson.fromJson(json, Profissao.class);
			pDAO.save(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(ProfissaoController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
