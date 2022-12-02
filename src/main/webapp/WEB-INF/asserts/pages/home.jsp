<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Dashboard</title>
</head>
<body>
    <div class="main-container">
        <div class="header">
                <div class="header-left">
                    <a href="#"><h3 class="active">My Posts</h3></a>
                    <a href="#"><h3>Shared Posts</h3></a>
                    <a href="./addpost"><h3>Add Post</h3></a>
                </div>
                <div class="header-right">
                    <h3>Welcome, ${userInSession.getuName()}</h3>
                    <a href="./logout"><input type="submit" value="Logout" id="logout"></a>
                </div>
        </div>
        <div class="container">
            <h1>My Posts</h1>
            <c:if test="${fn:length(msg) > 0}">
            	<div class="inner-container">
                	 <h4>${msg}</h4>
            	</div>
            </c:if>
        </div>
        <c:if test="${postsFound}">
        	<div class="container-flex-row">
        		<c:forEach items="${sessionUserPosts}" var="post">
        			<div class="card">
        				<a href="./seepost/${post.getpId()}">
            				<img src="resources\image\code.jpg" alt="Coding" width="100%">
               				<div class="card-desc">
       	            			<h2>${post.getpTitle()}</h2>
                    			<c:if test="${fn:length(post.getpDescription()) > 123}"><p>${fn:substring(post.getpDescription(), 0 ,123)}...</p></c:if>
                 				<c:if test="${fn:length(post.getpDescription()) <= 123}"><p>${post.getpDescription()}</p></c:if>                       
                 				<h3>${userInSession.getuName()}</h3>
                    			<label>${post.getpCreateDate()}</label>
               				</div>
               			</a> 
                		<div class="container">
    	            		<input type="submit" value="Edit" id="edit" onclick="location.href='./editpost/${post.getpId()}'">
                    		<input type="submit" value="Delete" id="delete" onclick="location.href='./deletepost/${post.getpId()}'">
                		</div>        
            		</div>
        		</c:forEach>
        	</div>
        </c:if>
        <c:if test="${!postsFound}">
        	<div class="container-flex-row-center">
            	<div class="card card-full-width">
                	<div class="card-top">
                    	<div class="card-desc-new">
                        	<h2>No Post Posted</h2>
                        	<p>Seems like, you have't posted anything yet. Kindly make a Post by clicking <a href="./addpost">Add Post.</a></p>
                    	</div>
                	</div>
            	</div>
        	</div>
        </c:if>
    </div>
</body>
</html>