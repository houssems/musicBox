
<%@page import="facebook4j.User"%>
<%@page import="facebook4j.Account"%>
<%@page import="facebook4j.ResponseList"%>
<%@page import="facebook4j.Facebook"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%


Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
ResponseList<Account> accounts = facebook.getAccounts();
//Account me = accounts.get(0); 
User me = facebook.getMe();
	out.println("User name: " + me.getName());
	out.println("Id: " +me.getId());
	out.println("Email: " +me.getEmail());
	out.println("<img src='" +facebook.getPictureURL()+"'/>");
	%>
</body>
</html>