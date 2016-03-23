
	 
				
	$(document).ready(function(){
		
		var  movieMap;
		
		var map ;
		
		var markers = [];
		
		
		
		 
		
    
		
		
		    
   			
		    
		    
		    
		 	
		 	 $("#movieName").keyup(function(){
		 		 
		 		 
					var movies = new Array();
					var movieNameInput = $(this);
					var input = $(this).val();
			
		            if(input.length > 3 ){
		            	
						 $.get("/rest/searchMovie/search/".concat(input),function(data,status){
							      if(status=="success"){
						    	      var jsonObject = data;		
							    	  
						    	      var arrayResultLength = (jsonObject["movies"]).length; 
									  
						    	  	  for(var i=0;i<arrayResultLength;i++){
						    	    	  movies[i] = jsonObject["movies"][i].title;  				    	      
									  }
									  
						    	  	var uniqueMovieNames = new Array();
						    	  	$.each(movies, function(i, el){
						    	  	    if($.inArray(el, uniqueMovieNames) === -1) uniqueMovieNames.push(el);
						    	  	});
						    	  	  
						    	  	  
						    	  	  	$(movieNameInput).autocomplete({source: uniqueMovieNames});						    	  	  
							     	 
									 }
									 
						   		 });
							}		  
					  	});	
		 	
		 	 
		 	$("#showMovieDetails").click(function(){
		 		
		 	 $('#loadingmessage').show();
		 	   
		 	 $("#infoDiv").empty();
				  
		 		
		 	  var input = $("#movieName").val();
	
		 	  if(input.length > 3 ){
		 		 
		 		  $.get("/rest/searchMovie/search/".concat(input), function(data,status){
		 			 if(status=="success"){
		 				 
		 				
		 			     var jsonObject = data;		
				         var arrayResultLength = (jsonObject["movies"]).length; 
				         movieMap = new Object();
								
				         if(jsonObject.total == 0) {
				        	 
				        	 $( "#notFoundError" ).text("No Movies found");
	   						  	$( "#dialog-modal" ).dialog({
	   						      height: 140,
	   						      modal: true
	   						    });
				        	 
				         }
				         
				         
				   			$("#carousel").empty();
				   			for(var i=0;i<arrayResultLength;i++){
			    	    	 
				        		var img = $('<img>'); //Equivalent: $(document.createElement('img'))
			    	    		var movieItem = (jsonObject["movies"][i]);
				        	    img.attr('src', (jsonObject["movies"][i]).posters.original);
				        		img.height(240);
			    	    		img.width(180);
			    	    		var id = movieItem.id;
			    	    		img.attr( "id", id);
			    	    		
			    	    		var movie_title = movieItem.title;
			    	    		var movie_year = movieItem.year;
			    	    		var movie_mpa_rating = movieItem.mpaa_rating;
			    	    		var movie_runtime = movieItem.runtime;
			    	    		
			    	    		var movie_critics_consensus = movieItem.critics_consensus; 
			    	    		
			    	    		if (typeof movieItem.critics_consensus == "undefined" ) {
			    	    			movie_critics_consensus = '';
			    	    		}
			    	    		
			    	    		var movie_cast = '';
			    	    		
			    	    		if(typeof movieItem.abridged_cast != "undefined" ) {
			    	    			for(var j=0;j<movieItem.abridged_cast.length;j++) {
			    	    				
			    	    				movie_cast = movie_cast + ''+ movieItem.abridged_cast[j].name +'|';
				    	    		
			    	    			}
			    	    		}
			    	    		
			    	    		movieMap[id] = new Movie(id,movie_title,movie_year,movie_mpa_rating,movie_runtime,movie_critics_consensus,movie_cast );
			    	    		
			    	    		img.click(function(e){
			    	    			showMovieInfoInDetail(e);
			    	    		});
			    	    		
			    	    		
			    	    		$("#carousel").append($(img));
			    	    	 
			    	     }
			    	   
				   			$("#carousel").waterwheelCarousel({
				   	          flankingItems: 3,
				   	          movingToCenter: function ($item) {
				   	            $('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
				   	          },
				   	          movedToCenter: function ($item) {
				   	            $('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
				   	          },
				   	          movingFromCenter: function ($item) {
				   	            $('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
				   	          },
				   	          movedFromCenter: function ($item) {
				   	            $('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
				   	          },
				   	          clickedCenter: function ($item) {
				   	            $('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
				   	          }
				   	        });
			    	 
				   		  $('#loadingmessage').hide();
			    	     
		 			 }
		 		  });
		 	  	}
		 	});
		 	
		 	
		  function showMovieInfoInDetail(event) {
			  
			  var movieToDisplay =  movieMap[event.currentTarget.id]; 
			  
			  var infoDivTag =  $("#infoDiv");
			  infoDivTag.empty();
			  
			  
			  var titleTag = $('<p></p>');
			  titleTag.append('<span style="font-weight:bold;text-decoration:underline">'+  movieToDisplay.title() + '</span>');
			  infoDivTag.append(titleTag);
			  
			  
			  var releaseYearTag = $('<p></p>');
			  releaseYearTag.append('<span style="font-weight:bold"> Released : </span>'+ movieToDisplay.releaseYear()+' ');
			  infoDivTag.append(releaseYearTag);
			  
			  
			  var mpaaTag = $('<p></p>');
			  mpaaTag.append('<span style="font-weight:bold"> MPAA Rating : </span>'+ movieToDisplay.mpaaRating()+' ');
			  infoDivTag.append(mpaaTag);
			  
			  
			  var runtimeTag = $('<p></p>');
			  runtimeTag.append('<span style="font-weight:bold"> Duration : </span>'+ movieToDisplay.runtime()+' (Minutes)');
			  infoDivTag.append(runtimeTag);
			  
			 
			  
			  var criticsConsensusTag = $('<p></p>');
			  criticsConsensusTag.append('<span style="font-weight:bold"> Critics Consensus : </span>'+ movieToDisplay.criticsConsensus()+' ');
			  infoDivTag.append(criticsConsensusTag);
			  
			  
			  
			  var castTag = $('<p></p>');
			  castTag.append('<span style="font-weight:bold"> Movie Cast : </span>'+ movieToDisplay.movieCast()+' ');
			  infoDivTag.append(castTag);
			  
			  
		  }
		  
		  
		  function Movie (id,movie_title,movie_year,movie_mpaa_rating,movie_runtime,movie_critics_consensus,movie_cast ){
			  this.id = id;
			  this.movie_title = movie_title;
			  this.movie_year = movie_year;
			  this.movie_mpaa_rating = movie_mpaa_rating;
			  this.movie_runtime = movie_runtime;
			  this.movie_critics_consensus = movie_critics_consensus;
			  this.movie_cast = movie_cast;
		  }
		  
		  
		  Movie.prototype.title = function(){
		      return this.movie_title;
		  }

		  
		  Movie.prototype.releaseYear = function(){
		      return this.movie_year;
		  }
		  
		  Movie.prototype.mpaaRating = function(){
			  if(this.movie_mpaa_rating == 'G'){
				  return 'General Audiences (G)';
			  }
			  
			  if(this.movie_mpaa_rating == 'PG'){
				  return 'Parental Guidance Suggested (PG)';
			  }
			  
			  if(this.movie_mpaa_rating == 'PG-13'){
				  return 'Parents Strongly Cautioned (PG-13)';
			  }
			  
			  if(this.movie_mpaa_rating == 'R'){
				  return 'Restricted (R)';
			  }
			  
			  if(this.movie_mpaa_rating == 'NC-17'){
				  return 'Adults Only (NC-17)';
			  }
			  
		      return this.movie_mpaa_rating;
		  }
		  
		  Movie.prototype.runtime = function(){
		      return this.movie_runtime;
		  }
		 	
		  
		  Movie.prototype.criticsConsensus = function(){
		      return this.movie_critics_consensus;
		  }
		  
		  
		  Movie.prototype.movieCast = function(){
		      return this.movie_cast;
		  }
			  
});