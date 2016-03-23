package org.issat.session;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.List;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.issat.model.Country;
import org.issat.model.Userprofile;
import org.issat.model.UserprofileArray;
import org.issat.model.Users;
import org.issat.model.UsersArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/users")
@Stateless
public class UserResource {

	final Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Context
    UriInfo uriInfo;

    @EJB
    UsersSession usersSession;
    
    @GET
    @Path("/list")
    @Produces( APPLICATION_XML )
    public Response getAll() {
    	List<Userprofile> users = usersSession.findAll();
    	UserprofileArray userArray=new UserprofileArray();
    	userArray.setUsers(users);
    	return Response.ok(userArray).build();
    }
    
    @Path("/delete/{id}")
    @DELETE
    public Response deleteCountry(@PathParam("id") long id) {
    	usersSession.delete(id);
    	return Response.noContent().build();
    	
    }
    

}
