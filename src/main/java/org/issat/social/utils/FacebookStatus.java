package org.issat.social.utils;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import facebook4j.Facebook;

@Path("/facebook")
public class FacebookStatus {
	@GET
	@Path("/submit/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object produceJSON( @PathParam("status") String status ) {
		
		return null;

	}
}
