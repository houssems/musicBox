package org.issat.search;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/search")
public class Artist {

	@GET
	@Path("/artist/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object produceJSON( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			 
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=artist.search&api_key=2d080e90cca2907b90aba5d09153b19a&format=json&artist="+name);
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
	
	@GET
	@Path("/similarArtist/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object similarArtist( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			name=name.replaceAll(" ", "+");
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=artist.getsimilar&api_key=2d080e90cca2907b90aba5d09153b19a&format=json&artist="+name);
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
	
	
	@GET
	@Path("/artistInfo/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getInfo( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			name=name.replaceAll(" ", "+");
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=artist.getInfo&api_key=2d080e90cca2907b90aba5d09153b19a&format=json&artist="+name);
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
	
	
	@GET
	@Path("/allEventLocations")
	@Produces(MediaType.APPLICATION_JSON)
	public Object allLocations() {
		HttpURLConnection conn=null;
		try {
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=geo.getmetros&api_key=2d080e90cca2907b90aba5d09153b19a&format=json");
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
	
	@GET
	@Path("/allEvents/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getEvents( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			name=name.replaceAll(" ", "+");
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=geo.getevents&api_key=2d080e90cca2907b90aba5d09153b19a&format=json&location="+name);
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