package org.issat.search;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.issat.session.NewsSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

@WebServlet("/newsUpdate")
public class News extends HttpServlet{

	@EJB
	NewsSession newsSession;
	private static final long serialVersionUID = 8703038566490703809L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//JSONObject json = NewsResource.getAll();
		//resp.getWriter().print();
		
		try {
			HttpURLConnection conn=null;
	    	URL url;
			
			url = new URL("http://api.nytimes.com/svc/mostpopular/v2/mostemailed/Technology/7.json?api-key=d19d08c8cadffc3cf54860a4181c3330:2:69320301");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept-Encoding", "identity");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			JSONObject json = (JSONObject) JSONValue.parse(new InputStreamReader(conn.getInputStream()));
			
			JSONArray msg = (JSONArray) json.get("results");
			Iterator<JSONObject> iterator = msg.iterator();
			while(iterator.hasNext()){
				JSONObject it = iterator.next();
				String urlstat=it.get("url").toString();
				//if(newsSession.findbyUrl(urlstat)==null){
					String title = (String) it.get("title");
					String abstracts = (String) it.get("abstract");
					String published_date =	(String) it.get("published_date");
					String byline = (String) it.get("byline");
					JSONParser jsonObject = new JSONParser();
					
					JSONArray img = (JSONArray) jsonObject.parse(it.get("media").toString());
					
					JSONObject imgs = (JSONObject) img.get(0);
					String caption = (String) imgs.get("caption");

					String urlimage =(String) ((JSONObject)((JSONArray)imgs.get("media-metadata")).get(2)).get("url");
					
					org.issat.model.News news=new org.issat.model.News();
					news.setAbstracts(abstracts);
					news.setByline(byline);
					news.setCaption(caption);
					news.setPublisheddate(published_date);
					news.setTitle(title);
					news.setUrl(urlstat);
					news.setUrlimage(urlimage);
					
					newsSession.create(news);
				//}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//RequestDispatcher rd = req.getRequestDispatcher(req.getContextPath() + "/news.html");
		//rd.forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/home.jsp#!news.jsp");
		
	}

	

}
