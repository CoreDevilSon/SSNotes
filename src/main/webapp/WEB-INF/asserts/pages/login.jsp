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
           <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
           <title>Sign in Page</title>
        </head>

        <body>
            <div class="main-container">
                <div class="container">
                    <h1>Sign in to your account</h1>
                </div>
                <div class="container">
                    <form action="./loginprocess" method="POST">

                        <div class="inner-container inner-container-top-border-radius">
                            <h4>${msg}</h4>
                        </div>

                        <div class="inner-container">
                            <label for="email">Email Address </label>
                            <input type="email" name="uEmail" id="email" placeholder="Enter your Email Address..">
                        </div>

                        <div class="inner-container">
                            <label for="password">Password </label>
                            <input type="password" name="uPassword" id="password" placeholder="Enter your Password..">
                        </div>


                        <div class="inner-container inner-container-bottom-border-radius">
                            <input type="submit" value="Sign In" id="signin">
                        </div>

                    </form>
                </div>
                <div class="container">
                    <div
                        class="inner-container inner-container-top-border-radius inner-container-bottom-border-radius ">
                        <p>
                            New user? <a href="./register">Create an account</a>.
                        </p>
                    </div>
                </div>


            </div>
        </body>

        </html>