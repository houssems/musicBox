<%@page import="facebook4j.Post"%>
<%@page import="facebook4j.ResponseList"%>
<%@page import="facebook4j.User"%>
<%@page import="facebook4j.Facebook"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<h1 class="caption">Listes de vos status</h1>
<div class="divider"></div>
<%
	Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
	User me = facebook.getMe();
	ResponseList<Post> feed = facebook.getHome();
	
	for(Post p : feed){
		out.print("<h1>"+p.getName()+"</h1>"); 
		out.print(p.getMessage()); 
		out.print("<div class='divider'></div>");
	} 
%>