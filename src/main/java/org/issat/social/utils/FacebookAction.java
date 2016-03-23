package org.issat.social.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookException;

@WebServlet("/postStatus")
public class FacebookAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6409499969808827944L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Facebook facebook = (Facebook) req.getSession().getAttribute("facebook");
		try {
			facebook.postStatusMessage(req.getParameter("status"));
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/home.jsp#!listestatus.jsp");
	}

}
