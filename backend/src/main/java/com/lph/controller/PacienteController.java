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
import com.lph.database.imp.EnderecoDAO;
import com.lph.database.imp.MunicipioDAO;
import com.lph.database.imp.PacienteDAO;
import com.lph.database.imp.UnidadeFederativaDAO;
import com.lph.model.Endereco;
import com.lph.model.Municipio;
import com.lph.model.Paciente;
import com.lph.model.UnidadeFederativa;

@Path("pacientes")
public class PacienteController {
	
	private PacienteDAO pDAO;
	private EnderecoDAO eDAO;
	private MunicipioDAO mDAO;
	private UnidadeFederativaDAO uDAO;
	
	public PacienteController() {
		this.pDAO = new PacienteDAO(Paciente.class);
		this.eDAO = new EnderecoDAO(Endereco.class);
		this.mDAO = new MunicipioDAO(Municipio.class);
		this.uDAO = new UnidadeFederativaDAO(UnidadeFederativa.class);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Paciente> getPacientes() {
		try {
			return pDAO.listAll();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/salvar/")
	public Response createPaciente(String json) {
		try {
			Gson gson = new Gson();
			Paciente n = gson.fromJson(json, Paciente.class);
			uDAO.save(n.getEndereco().getMunicipio().getUnidadeFederativa());
			mDAO.save(n.getEndereco().getMunicipio());
			eDAO.save(n.getEndereco());
			pDAO.save(n);
			return Response.status(Response.Status.OK).build();
		}catch(SQLException | ClassNotFoundException e){
			Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, e);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
