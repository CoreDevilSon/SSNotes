<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
            <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap"
                rel="stylesheet">
            <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
            <style>
                .container .inner-container {
                    width: 100%;
                }
            </style>
            <title>Create a Post</title>
        </head>

        <body>
            <div class="main-container">
                <div class="header">
                <div class="header-left">
                    <a href="./dashboard"><h3>My Posts</h3></a>
                    <a href="#"><h3>Shared Posts</h3></a>
                    <a href="#"><h3 class="active">Add Post</h3></a>
                </div>
                <div class="header-right">
                    <h3>Welcome, ${userInSession.getuName()}</h3>
                    <a href="./logout"><input type="submit" value="Logout" id="logout"></a>
                </div>
        </div>
                <div class="container">
                    <h1>Create your Post</h1>
                </div>
                <div class="container">
                    <form action="addpostprocess" method="POST">

                        <div class="inner-container inner-container-top-border-radius">
                            <h4>${msg}</h4>
                        </div>
                        <div class="inner-container">
                            <label for="title">Title </label>
                            <input type="text" name="pTitle" id="title" placeholder="Enter your title..">
                        </div>

                        <div class="inner-container">
                            <label for="description">Description </label>
                            <textarea id="description" name="pDescription" placeholder="Enter your desscription.."></textarea>
                        </div>

                        <div class="inner-container">
                            <label for="code">Code(Optional)</label>
                            <textarea id="code" name="pCode" placeholder="Enter your code.."></textarea>
                        </div>

						<div class="inner-container">
                            <label>Visibility</label>
                            <div class="inner-container inner-container-grey-background">
                                <label for="public">Public</label><span>Makes your post available for anyone on the web to read and view.</span>
                                <input type="radio" id="public" name="pVisibility" value="public">
                                <label for="private">Private</label><span>Makes your post private for people on the web to read and view.</span>
                                <input type="radio" id="private" name="pVisibility" value="private" checked>
                            </div>
                        </div>
                        <div class="inner-container inner-container-bottom-border-radius">
                            <input type="submit" value="Create Post" id="createpost">
                        </div>

                    </form>

                </div>

            </div>
        </body>

        </html>