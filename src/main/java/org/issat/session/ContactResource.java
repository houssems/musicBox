package org.issat.session;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



import org.issat.model.Contact;
import org.issat.model.ContactArray;
import org.issat.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/contact")
@Stateless
public class ContactResource {
	final Logger logger = LoggerFactory.getLogger(CountryResource.class);

	@Context
    UriInfo uriInfo;

    @EJB
    ContactSession contactSession;
    
    
    
    @GET
    @Path("/list")
    @Produces( APPLICATION_XML )
    public Response getAll() {

		List<Contact> contacts = contactSession.findAll();
		ContactArray contactArray = new ContactArray();
		contactArray.setContact(contacts);
		return Response.ok(contactArray).build();
    }
    
    @Path("/add")
    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public Response create( @FormParam("name") String name,
    						@FormParam("email") String email,
    						@FormParam("description") String msg) {
    	logger.info("creation de contact");
        Contact c=new Contact(email, name, msg);
        contactSession.create(c);
        logger.info("creation termine de contact");
       
        return Response.ok().build();

    }
    
}
