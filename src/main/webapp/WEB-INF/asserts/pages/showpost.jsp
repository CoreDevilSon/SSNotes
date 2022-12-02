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
    <title>${postDetails.getpTitle()}</title>
    <style>
    	.card-code {
    		width: 100%;
    		margin-top: 6px;
   	 		padding: 12px;
    		outline: none;
    		border-radius: 10px;
    		border: 1px solid rgb(208, 208, 208);
    		background-color:#404040;
    		height: 300px;
    		color: white;
    		white-space: pre;
    		overflow: scroll;
    	}
    </style>
</head>
<body>
    <div class="main-container">
        <div class="header">
            <div class="header-left">
                    <a href="../dashboard"><h3>My Posts</h3></a>
                    <a href="#"><h3>Shared Posts</h3></a>
                    <a href="../addpost"><h3>Add Post</h3></a>
                </div>
                <div class="header-right">
                    <c:if test="${fn:length(userInSession.getuName()) > 0}">
                    	<h3>Welcome, ${userInSession.getuName()}</h3>
                   	 	<a href="../logout"><input type="submit" value="Logout" id="logout"></a>
                    </c:if>
                    <c:if test="${fn:length(userInSession.getuName()) <= 0}">
                    	<h3>Welcome, Guest</h3>
                   	 	<a href="../login"><input type="submit" value="Login" id="logout"></a>
                    </c:if>
                </div>
        </div>
        <div class="container-flex-row-center">
            <div class="card card-full-width">
                <div class="card-top">
                    <img src="<c:url value = '/resources/image/code.jpg' />" alt="Coding" width="100%">
                    <div class="card-desc-new">
                        <h2>${postDetails.getpTitle()}</h2>
                        <p>${postDetails.getpDescription()}</p>
                    	
                    	<c:if test="${fn:length(postDetails.getpCode()) > 0}">
                    		<div class="card-code"><pre>${postDetails.getpCode()}</pre></div>
                    	</c:if>
    
                        <h3>${postOwnerName}</h3>
                        <label>${postDetails.getpCreateDate()}</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>