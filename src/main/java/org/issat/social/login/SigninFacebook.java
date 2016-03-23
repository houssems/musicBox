package org.issat.social.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;

@WebServlet("/signinFacebook")
public class SigninFacebook extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("400936846648306", "a65e1b61274e3321a4119e23606a9c27");
		facebook.setOAuthPermissions("public_profile,user_friends,user_about_me,user_photos,read_stream,email,publish_stream");
		 request.getSession().setAttribute("facebook", facebook);
	      StringBuffer callbackURL = request.getRequestURL();
	        int index = callbackURL.lastIndexOf("/");
	        callbackURL.replace(index, callbackURL.length(), "").append("/callbackFacebook");
	        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
