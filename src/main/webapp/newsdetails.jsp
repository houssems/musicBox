<%@page import="org.issat.model.News"%>
<%@page import="org.issat.session.NewsResource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%-- <% --%>
// String id=request.getParameter("id");
// NewsResource n=new NewsResource();
// News news=n.getnews(id);
<%-- %> --%>
<%-- <h1 class="caption"><% news.getTitle(); %></h1> --%>
<!-- <div class="divider"></div> -->
<%-- <img src="<% out.print(news.getUrlimage()); %>" width="600" height="350" /> --%>

<div class="divider"></div>
<h4>Abstract</h4>
<div class="divider" style="height:13px"></div>
<%-- <% out.println(news.getAbstracts());  --%>
// out.println("Read more: <a href='"+news.getUrl()+"'>Continue</a>");

<%-- %> --%>

<hr class="seperator" /> 

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/fr_FR/sdk.js#xfbml=1&appId=265023510311304&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<div class="clearfix"></div>

<script>
function getUrlVar(key){
	var result = new RegExp(key + "=([^&]*)", "i").exec(window.location.search); 
	return result && unescape(result[1]) || ""; 
}


var id=getUrlVar(id);
alert(id);

</script>