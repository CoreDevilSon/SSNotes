<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <h3 class="active">My Posts</h3>
                    <h3>Search Post</h3>
                    <h3>Add Post</h3>
                </div>
                <div class="header-right">
                    <h3>Welcome Anurag Saini Priyanka Saini</h3>
                    <input type="submit" value="Logout" id="logout">
                </div>
        </div>
        <div class="container">
            <h1>My Posts</h1>
        </div>
        <div class="container-flex-row">
            <div class="card">
                <div class="card-top">
                    <img src="<c:url value="/resources/image/code.jpg" />" alt="Coding" width="100%">
                    <div class="card-desc">
                        <h2>Classes-Objects & Deserialization bug</h2>
                        <p>Almost all industrial people (working for some organisation) use Object-Oriented Programming. Not all programming languages</p>
                    
                        <h3>Anurag Saini</h3>
                        <lavel>24 May 2022</label>
                    </div>
                    <div class="container">
                        <input type="submit" value="Edit" id="edit">
                        <input type="submit" value="Delete" id="delete">
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-top">
                    <img src="resources\image\code.jpg" alt="Coding" width="100%">
                    <div class="card-desc">
                        <h2>Classes-Objects & Deserialization bug</h2>
                        <p>Almost all industrial people (working for some organisation) use Object-Oriented Programming. Not all programming languages</p>
                    
                        <h3>Anurag Saini</h3>
                        <lavel>24 May 2022</label>
                    </div>
                    <div class="container">
                        <input type="submit" value="Edit" id="edit">
                        <input type="submit" value="Delete" id="delete">
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-top">
                    <img src="resources\image\code.jpg" alt="Coding" width="100%">
                    <div class="card-desc">
                        <h2>Classes-Objects & Deserialization bug</h2>
                        <p>Almost all industrial people (working for some organisation) use Object-Oriented Programming. Not all programming languages</p>
                    
                        <h3>Anurag Saini</h3>
                        <lavel>24 May 2022</label>
                    </div>
                    <div class="container">
                        <input type="submit" value="Edit" id="edit">
                        <input type="submit" value="Delete" id="delete">
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>