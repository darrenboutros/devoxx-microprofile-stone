package fr.devoxx.microprofile.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.devoxx.microprofile.model.Stone;
import fr.devoxx.microprofile.service.StoneService;

@Path("stones")
@ApplicationScoped
public class StoneResource {
	

	@Inject 
	StoneService stoneService;
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Stone findStone(@PathParam("id") Integer id) {
		return stoneService.findById(id);
	
	}

}
