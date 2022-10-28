<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <title>Register Page</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            background-color: rgb(0, 76, 144, 0.8);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            font-family: 'Roboto', sans-serif;
        }
        h1 {
            padding-top: 40px ;
            padding-bottom: 40px;
            color: #fff;
            font-weight: 300;
        }
        form {
            background-color: rgb(255, 255, 255);
            display: flex;
            flex-direction: column;
            align-items: left;
            padding: 35px 20px;        
            width: 30%;
            border-radius: 3px;
        }

    	.form-inner-div {
        	margin-bottom: 1.5em;
    	}

    	input {
        	width:100%;
        	margin-top: 7px;
        	padding: 12px;
        	outline: none;
        	border-radius: 3px;
        	border: 1px solid rgb(208, 208, 208);
        	background-color: rgb(240, 240, 240);
    	}

    	#signup {
        	background-color: rgb(46, 146, 22);
        	color: white;
    	}

    	p {
        	text-align: center;
        	margin-top: 5px;
        	font-weight:300;
    	} 
    	label {
    		font-weight:500;
    	}
    </style>
</head>
<body>
    <h1>Register your account</h1>
    <h4>${msg}</h4><br>
    <form action="registerprocess" method="POST">
        <div class="form-inner-div">
            <label for="name">Name </label><br>
            <input type="text" name="uName" id="name" placeholder="Enter your name..">
          </div>

          <div class="form-inner-div">
            <label for="username">Username </label><br>
            <input type="text" name="uUserName" id="username" placeholder="Enter a username..">
          </div>

          <div class="form-inner-div">
            <label for="email">Email Address </label><br>
            <input type="email" name="uEmail" id="email" placeholder="Enter your Email Address..">
          </div>

          <div class="form-inner-div">
            <label for="password">Password </label><br>
            <input type="password" name="uPassword" id="password" placeholder="Enter your Password..">
          </div>

          <div class="form-inner-div">
            <label for="confirm">Confirm Password </label><br>
            <input type="password" name="uPasswordConfirm" id="confirm" placeholder="Enter your Password again..">
          </div>

          <div class="form-inner-div">
            <input type="submit" value="Sign Up" id="signup">
          </div>

          <p>
            Already have an account? <a href="./login">Sign in</a>.
          </p>
            
          
    </form>
    
</body>
</html>