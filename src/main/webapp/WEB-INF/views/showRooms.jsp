<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.MeetingRoom" %>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <spring:url value="/resources/images" var="images" />
</head>
<body>
 <% String username = (String)request.getAttribute("username"); %>

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

List of Rooms-
<div class="container">
  <h2>Basic Table</h2>
            
  <table class="table">
    <thead>
      <tr>
      <th>Id</th>
        <th>Meeting Room Name</th>
        <th>Meeting Room Address</th>
        <th>>Meeting Room description</th>
       
         <th>Image<th>
      </tr>
    </thead>
    <tbody>
     <% ArrayList rooms = (ArrayList)request.getAttribute("rooms"); 
  
   for (int i = 0; i < rooms.size(); i++) { 
        MeetingRoom room =(MeetingRoom)rooms.get(i);  %>  
      <tr>
      <td><% out.print(room.getRoomId()); %></td>
        <td><% out.print(room.getRoomName()); %></td>
        <td><% out.print(room.getRoomAddress()); %></td>
        <td><% out.print(room.getRoomDescr()); %></td>
        
         <td>
       
						  				<img src="${images}/<%=room.getImageUrl() %>" width="200px" alt=""/>
						  	
						  			</td>	
         <td><a href="/book<%= room.getRoomId()%>">Book</a></td>
      </tr>
      
        <% } %>
     
    </tbody>
  </table>
</div>
</html>