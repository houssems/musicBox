<%@page import="facebook4j.IdNameEntity"%>
<%@page import="facebook4j.User.Education"%>
<%@page import="java.util.List"%>
<%@page import="facebook4j.PictureSize"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="facebook4j.User"%>
<%@page import="facebook4j.Account"%>
<%@page import="facebook4j.ResponseList"%>
<%@page import="facebook4j.Facebook"%>
<%
	Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
	User me = facebook.getMe();
	
%>

<h1 class="caption">User Profile</h1>
<div class="divider"></div>
<img src="<% out.print(facebook.getPictureURL(PictureSize.large)); %>" width="600" height="350" />
<div class="divider"></div>
<div id="singleLeft">
<% 

out.println("<h4>General Information</h4>");
out.println("<span style='font-weight:bold'>Id:  </span>" +me.getId()+"<br>");
out.println("<span style='font-weight:bold'>Email: </span>" +me.getEmail()+"<br>");
out.println("<span style='font-weight:bold'>Birthday: </span>" +me.getBirthday()+"<br>");
out.println("<span style='font-weight:bold'>Bio: </span>" +me.getBio()+"<br>");


out.println("<h4>Education: </h4><ul class='list circle'>");
List<Education> e=me.getEducation();
for(int i=0;i<e.size();i++)
	out.println("<li>"+e.get(i).getType()+": "+e.get(i).getSchool().getName()+"</li>");
out.println("</ul>");



%>
<div class="contactForm dform">
<form action="/postStatus">
		<p>
			<label for="description">Status</label>
			<input type="hidden" id="description_title" name="title[]" value="Status" />
			<div class="dFormInput">
				<textarea class="required" id="status" name="status" ></textarea>
			</div>
		</p>
		<p style="padding:0px;">
			<label for="submit">&nbsp;</label>
			<div class="form_input">
				<a class="nolink submitButton" id="valider" onclick="document.forms[0].submit();return false;">SUBMIT</a>
			</div>
		</p>
</form>
</div>
</div>
<div id="singleRight">
	<div class="singleDateBlock">
		<div class="singleDate"></div>
	</div>
	<ul>
		<li><div class="singleAuthor"></div><span><%out.println(me.getName());%></span></li>
		<li><div class="singleTags"></div><span>Design, Web, Print</span></li>
	</ul>
</div>

<hr class="seperator" />
<div class="clearfix"></div>
