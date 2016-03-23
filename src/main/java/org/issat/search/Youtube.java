package org.issat.search;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/searchYoutube")
public class Youtube {

	@GET
	@Path("/playlist/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object playlist( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			name=name.replaceAll(" ", "+");
			URL url = new URL("https://gdata.youtube.com/feeds/api/playlists/snippets?key=AIzaSyDc2OmeFV3h-WI-4mf6PFC2L35l0BXUnjE&v=2&alt=jsonc&max-results=10&q="+name);
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
	@Path("/loadPlaylistItem/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getInfo( @PathParam("name") String name ) {
		HttpURLConnection conn=null;
		try {
			 
			URL url = new URL("https://www.googleapis.com/youtube/v3/playlistItems?key=AIzaSyDc2OmeFV3h-WI-4mf6PFC2L35l0BXUnjE&part=snippet&playlistId="+name);
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
