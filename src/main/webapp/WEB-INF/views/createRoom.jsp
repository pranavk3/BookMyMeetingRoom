<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BookMyMeetingRoom</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a class="" data-toggle="" href="createroom">Add Meeting Room<span class=""></span></a>
    
      </li>
      <li><a href="#">Delete Meetings</a></li>
        <li><a href="#">Update Meetings</a></li>
        
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><span class=""></span>welcome ${username}</a></li>
     <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>LogOut</a></li>
    </ul>
  </div>
</nav>
<div class="container">
    		<h3>Create Meeting Room</h3>
    		<hr/>
        <div class="row">
        		<%-- Registration form code --%>
        		<div class="col-md-offset-2 col-md-8">
        		   
			   <form:form method="post" modelAttribute="roomForm" action="savemeetingroom" class="form-signin" enctype="multipart/form-data">
			   <div class="form-group">
		        <label for="inputEmail" class="">Meeting Room Name</label>
		        <input type="text" name="roomName" id="inputEmail" class="form-control" placeholder="Meeting Room Name" required autofocus>			   
			   </div>
			    <div class="form-group">
		        <label for="inputEmail" class="">Meeting Room Address</label>
		        <input type="text" name="roomAddress" id="inputEmail" class="form-control" placeholder="Meeting Room Address" required autofocus>			   
			   </div>
			    <div class="form-group">
		        <label for="inputEmail" class="">Room Description</label>
		        <textarea name="roomDescr" id="inputEmail" class="form-control" placeholder="Room Description" required autofocus></textarea>			   
			   </div>
			   
			    
			   
			   <fieldset class="form-group">
		  	<div class="row">
		  		<div class="col-md-6">
				    <label for="uploadImage">Upload Image</label>
			    		<input type="file" class="form-control-file" id="uploadImage" name="file" />
	    		  		<%-- <form:errors path="file"/>  --%>
	    		  		<form:hidden path="imageUrl"/>	    		  		
		  		</div>
		  		</div>
		  		</fieldset>
			  
		       
		        <div class="form-group">
		        <button class="btn btn-sm btn-primary" type="submit">Create</button>
		        </div>
		         </form:form>
		        </div>
		       
		      
	      </div>        		                		
        
        
        </div>
</body>
</html>