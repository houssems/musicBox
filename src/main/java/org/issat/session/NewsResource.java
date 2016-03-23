package org.issat.session;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.issat.model.News;
import org.issat.model.NewsArray;

@Path("/news")
@Stateless
public class NewsResource {

	@Context
    UriInfo uriInfo;

    @EJB
    NewsSession newsSession;
    
    @GET
    @Path("/list")
    @Produces( MediaType.APPLICATION_JSON )
    public Response getList() {
    	List<News> news=newsSession.findAll();
    	NewsArray array=new NewsArray();
    	array.setNews(news);
    	
    	return Response.ok(array).build();
    }
    
    @GET
    @Path("/all")
    @Produces( MediaType.APPLICATION_JSON )
    public static Object getAll() {
    	HttpURLConnection conn=null;
    	URL url;
		try {
			url = new URL("http://api.nytimes.com/svc/mostpopular/v2/mostemailed/Technology/7.json?api-key=d19d08c8cadffc3cf54860a4181c3330:2:69320301");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept-Encoding", "identity");
	    	return conn.getContent();
		} catch (Exception e) {
			return null;
		}
		
    }
    
    @GET
    @Path("/get/{id}")
    @Produces( MediaType.APPLICATION_XML )
    public News getnews(@PathParam(value="id") long id) {
    	News news= newsSession.find(id);
    	return news;
    }
    
}
