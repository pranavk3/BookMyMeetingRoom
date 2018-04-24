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
   
   
   
   
   
   
   <style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 3s;
  animation-name: fade;
  animation-duration: 3s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>
</head>
<body>
 <% String username = (String)request.getAttribute("username"); %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BookMyMeetingRoom</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      
        <li><a class="" data-toggle="" href="showmeetingrooms">show Meeting Rooms<span class=""></span></a>
      <li><a class="" data-toggle="" href="createroom">Add Meeting Room<span class=""></span></a>
    
      </li>
      <li><a href="#">Delete Meetings</a></li>
        <li><a href="#">Update Meetings</a></li>
        
           <li><a href="showMeeting">show meeting</a></li>
        
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li><a href="#"><span class=""></span>welcome ${username}</a></li>
     <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>LogOut</a></li>
    </ul>
  </div>
</nav>


<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="${images}/i4.jpg" style="width:100%">
  <div class="text">Caption Text</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="${images}/i5.jpg" style="width:100%">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="${images}/i3.jpeg" style="width:100%">
  <div class="text">Caption Three</div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>


<%-- List of Rooms-
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
         <td><a href="/book/<%= room.getRoomId()%>">Book</a></td>
      </tr>
      
        <% } %>
     
    </tbody>
  </table> --%>
</div>
</html>