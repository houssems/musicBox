<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="org.issat.session.NewsSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<h1 class="caption">Hot news</h1>
<div class="divider"></div>

<h1>Latest News</h1>
<div class="divider"></div>

<div id="eventlist">

</div>			
			
			




<hr class="seperator" />
<div class="clearfix"></div>
<script>
$(function(){
	
	  $.get("/rest/news/list",function(data,status){
		  if(status=="success") { 
			  var jsonNews = data;
			  var NewsLength =jsonNews.news.length;
			  var map = new Object();						  
			  for(var i=0;i<NewsLength;i++){
				  var array = jsonNews.news;
				  var news= '<div class="blogitem">'+
				  			'<h3>'+array[i].title+'</h3>'+
				  			'<div class="blogimage">'+
				  				'<div class="image_frame">'+
				  				'<a href="'+array[i].urlimage+'">'+
				  					'<img src="'+array[i].urlimage+'" width="350" height="225" title="'+array[i].title+'" alt="'+array[i].caption+'"/>'+
				  				'</a>'+
				  			'<div class="hoverWrapperBg"></div>'+
				  			'<div class="hoverWrapper">'+
				  				'<a class="link" href="/home.jsp#!news.jsp?id='+array[i].id+'"></a>'+
				  				'<a class="modal" href="javascript:void(0);"></a>'+
				  				'</div>'+
				  			'</div>'+
				  		'</div>'+	
				  		'<div class="blogcontent">'+
							'<div class="blogdatemeta">'+
								'<div class="blogdate">'+array[i].publisheddate+'</div>'+
								'<div class="meta-links">'+
									'<a class="meta-author" href="javascript:void(0);" rel="'+array[i].byline+'"></a>'+
									'<a class="meta-comments" href="javascript:void(0);" rel="no Comments"></a>'+
									'<a class="meta-tags" href="javascript:void(0);" rel="Technology"></a>'+
								'</div>'+
						'</div>'+
							'<p>'+
							array[i].abstracts+
							'</p>'+
							'<a class="morelink" href="/home.jsp#!newsdetails.jsp?id='+array[i].id+'">READ MORE</a>'+
							'</div>'+
						'<hr class="seperator"/>'+
						'<div class="clearfix"></div>'+
						'</div>';
						//alert(news);
						$("#eventlist").append(news);
				
			  }						  
			  
		 	 }
	  	});		
});	
</script>