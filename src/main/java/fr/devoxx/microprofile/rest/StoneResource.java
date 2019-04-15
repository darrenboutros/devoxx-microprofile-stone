package fr.devoxx.microprofile.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.devoxx.microprofile.model.Stone;

@Path("stones")
public class StoneResource {
	

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Stone findStone(@PathParam("id") Integer id) {
		return new Stone(3, "Space", "Blue");
	
	}

}
