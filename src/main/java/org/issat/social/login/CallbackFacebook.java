package org.issat.social.login;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.issat.model.Userprofile;
import org.issat.model.Users;
import org.issat.session.UsersSession;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.User;

@WebServlet("/callbackFacebook")
public class CallbackFacebook extends HttpServlet{
	
	private static final long serialVersionUID = 1336627072335799759L;

	@EJB
	UsersSession usersSession;
	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
	        String oauthCode = request.getParameter("code");
	        try {
	            facebook.getOAuthAccessToken(oauthCode);
	            User me = facebook.getMe();
	            if(usersSession.findSocial(me.getId(), "facebook")==null){
	            	Userprofile u = new Userprofile();
	            	u.setName(me.getName());
	            	u.setIdSocial(me.getId());
	            	u.setSocialtype("facebook");
	            	u.setEmail(me.getEmail());
	            	u.setImg(facebook.getPictureURL().getPath());
	            	usersSession.create(u);
	            }
	        } catch (FacebookException e) {
	            throw new ServletException(e);
	        }
	       
	        response.sendRedirect(request.getContextPath() + "/home.jsp");
	    }
}
