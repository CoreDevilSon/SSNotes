<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page isELIgnored="false" %>
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
            <title>Register Page</title>

            <style>
                * {
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                }

                body {
                    background-color: rgb(0, 76, 144, 0.8);
                    align-items: center;
                    font-family: 'Roboto', sans-serif;
                }

                .main-container {
                    margin: auto;
                    /* border: 2px solid red; */
                    padding-top: 0px;
                    padding-bottom: 0px;
                    width: 70%;

                }

                .container {
                    /* border: 2px solid black; */
                    padding-top: 20px;
                    padding-bottom: 20px;
                    text-align: left;
                }

                .container .inner-container {
                    display: flex;
                    flex-direction: column;
                    padding: 20px 40px;
                    width: 50%;
                    margin: auto;
                    background-color: white;
                    overflow-y: auto;

                }

                .container .inner-container h4 {
                    color: red;
                    text-align: center;
                }

                .container h1 {
                    color: #fff;
                    font-weight: 300;
                    text-align: center;
                }

                .inner-container p {
                    text-align: center;
                    font-weight: 300;
                }

                .inner-container label {
                    font-weight: 500;
                }

                .inner-container-top-border-radius {
                    border-top-left-radius: 5px;
                    border-top-right-radius: 5px;
                }

                .inner-container-bottom-border-radius {
                    border-bottom-left-radius: 5px;
                    border-bottom-right-radius: 5px;
                }

                .inner-container input {
                    width: 100%;
                    margin-top: 6px;
                    padding: 12px;
                    outline: none;
                    border-radius: 3px;
                    border: 1px solid rgb(208, 208, 208);
                    background-color: rgb(240, 240, 240);
                }

                .inner-container #signin,
                #signup {
                    background-color: rgb(46, 146, 22);
                    color: white;
                }

                .inner-container a {
                    color: rgb(0, 76, 144, 1);
                }
            </style>
        </head>

        <body>
            <div class="main-container">
                <div class="container">
                    <h1>Register your account</h1>
                </div>
                <div class="container">
                    <form action="registerprocess" method="POST">

                        <div class="inner-container inner-container-top-border-radius">
                            <h4>${msg}</h4>
                        </div>
                        <div class="inner-container">
                            <label for="name">Name </label>
                            <input type="text" name="uName" id="name" placeholder="Enter your name.."
                                value="${user.uName}">
                        </div>

                        <div class="inner-container">
                            <label for="username">Username </label>
                            <input type="text" name="uUserName" id="username" placeholder="Enter a username.."
                                value="${user.uUserName}">
                        </div>

                        <div class="inner-container">
                            <label for="email">Email Address </label>
                            <input type="email" name="uEmail" id="email" placeholder="Enter your Email Address.."
                                value="${user.uEmail}">
                        </div>

                        <div class="inner-container">
                            <label for="password">Password </label>
                            <input type="password" name="uPassword" id="password" placeholder="Enter your Password..">
                        </div>

                        <div class="inner-container">
                            <label for="confirm">Confirm Password </label>
                            <input type="password" name="uPasswordConfirm" id="confirm"
                                placeholder="Enter your Password again..">
                        </div>

                        <div class="inner-container">
                            <input type="submit" value="Sign Up" id="signup">
                        </div>

                    </form>

                    <div class="inner-container inner-container-bottom-border-radius">
                        <p>
                            Already have an account? <a href="./login">Sign in</a>.
                        </p>
                    </div>
                </div>

            </div>

        </body>

        </html>