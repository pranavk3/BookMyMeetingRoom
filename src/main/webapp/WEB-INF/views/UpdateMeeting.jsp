<!DOCTYPE html>
<html lang="en">
<head>
<%@ page import="com.model.Meeting" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <spring:url value="/resources/images" var="images" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
  <% Meeting room =(Meeting)request.getAttribute("meetingRoom"); %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home">BookMyMeetingRoom</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/home">Home</a></li>
         <li><a class="" data-toggle="" href="showmeetingrooms">show Meeting Rooms<span class=""></span></a>
      <li><a class="" data-toggle="" href="createroom">Add Meeting Room<span class=""></span></a>
    
      </li>
      <li><a href="#">Delete Meetings</a></li>
        <li><a href="#">Update Meetings</a></li>
           <li><a href="showMeeting">show meeting</a></li>
        
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><span class=""></span>welcome <%= session.getAttribute("nickName") %></a></li>
     <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>LogOut</a></li>
    </ul>
  </div>
</nav>
<div class="container">
    		<h3>Book Meeting Room</h3>
    		<hr/>
        <div class="row">
        		<%-- Registration form code --%>
        		<div class="col-md-offset-2 col-md-8">
        		   
			   <form:form method="post" modelAttribute="meetingForm" action="updatemeeting" class="form-signin">
			   <div class="form-group">
			    <div class="form-group">
		        <label for="inputEmail" class="">Meeting Room ID</label>
		        <input type="text" name="meetingId" id="inputEmail" class="form-control" readonly="readonly" value="<% out.print(room.getMeetingId()); %>" required autofocus>			   
			   </div>
		        <label for="inputEmail" class="">Meeting Room Name</label>
		        <input type="text" name="meetingRoomName" id="inputEmail" class="form-control"  readonly="readonly" value="<% out.print(room.getMeetingRoomName()); %>" required autofocus>			   
			   </div>
			   
		  		
		  		   <div class="form-group">
		        <label for="inputEmail" class="">From Date</label>
		        <input type="date" name="dateFrom" value="<% out.print(room.getDateFrom()); %>" id="inputEmail" class="form-control" required autofocus>			   
			   </div>
			  
			  
		  		   <div class="form-group">
		        <label for="inputEmail" class="" >To Date</label>
		        <input type="date" name="dateTo"  value="<% out.print(room.getDateTo()); %>" id="inputEmail" class="form-control" required autofocus>			   
			   </div>
			   
			    <div class="form-group">
		        <label for="inputEmail" class="">From Time</label>
		        <input type="time" name="timeFrom"  value="<% out.print(room.getTimeFrom()); %>" id="inputEmail" class="form-control" required autofocus>			   
			   </div>
			   
			    <div class="form-group">
		        <label for="inputEmail" class="">To Time</label>
		        <input type="time" name="timeTo" value="<% out.print(room.getTimeTo()); %>" id="inputEmail" class="form-control" required autofocus>			   
			   </div>
			  
		       
		        <div class="form-group">
		        <button class="btn btn-sm btn-primary" type="submit">Update Meeting Room</button>
		        </div>
		         </form:form>
		        </div>
		       
		      
	      </div>        		                		
        
        
        </div>
</body>
</html>