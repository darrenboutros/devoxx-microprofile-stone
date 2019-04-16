package fr.devoxx.microprofile.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.devoxx.microprofile.model.Stone;
import fr.devoxx.microprofile.service.StoneService;

@Path("stones")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class StoneResource {
	

	@Inject 
	StoneService stoneService;
	
	@Path("/{id}")
	@GET
	public Stone findStone(@PathParam("id") Integer id) {
		return stoneService.findById(id);
	
	}
	
	
	@GET
	public List<Stone> retrieveStones (){
		return stoneService.findAll();
	}

	@GET
	public List<Stone> retrieveStonesById (@QueryParam(value = "name") String name){
		return stoneService.findByName(name);
	}
}
