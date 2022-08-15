<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <title>Sign in Page</title>

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
    	#signin {
        	background-color: rgb(46, 146, 22);
        	color: white;
    	}

    	p {
        	padding: 40px;
        	background-color: #fff;
        	text-align: center;
        	margin-top: 35px;
        	width: 30%;
        	border-radius: 3px;
        	font-weight: 300;
    	}
    	label {
    		font-weight:500;
    	}
    </style>
</head>
<body>
    <h1>Sign in to your account</h1>
    <form>
          <div class="form-inner-div">
            <label for="email">Email Address </label><br>
            <input type="email" name="email" id="email" placeholder="Enter your Email Address.." required>
          </div>

          <div class="form-inner-div">
            <label for="password">Password </label><br>
            <input type="password" name="password" id="password" placeholder="Enter your Password.." required>
          </div>


          <div class="form-inner-div">
            <input type="submit" value="Sign In" id="signin">
          </div>  
          
    </form>

    <p>
        New user? <a href="register">Create an account</a>.
    </p>
    
</body>
</html>