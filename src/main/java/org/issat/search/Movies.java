package org.issat.search;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/searchMovie")
public class Movies {

	@GET
	@Path("/search/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object playlist( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			name=name.replaceAll(" ", "+");
			URL url = new URL("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=dkuw4r3tpwm68knm8mbmwy6p&q="+name);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
	 
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			return conn.getContent();
		 
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
		
		return null;

	}
}
