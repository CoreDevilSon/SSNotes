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
    <title>Dash-board</title>

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
            color: white;
            font-weight: 300;
        }
        h2 {
            padding-top: 10px ;
            padding-bottom: 10px;
            color: black;
            font-weight: 300;
        }
        .message-area h4 {
        	color:red;
        	margin-bottom: 20px;
        	text-align: center;
        }
        .form h1 {
            padding-top: 0px ;
            padding-bottom: 0px;
            color: black;
            font-weight: 300;
        }
        .form p {
            padding-bottom: 20px;
            color: black;
            font-weight: 300;
            line-height:25px;
        }
        .form {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: left;
            padding: 35px 20px;
            padding-top:0px;        
            width: 80%;
            border-radius: 3px;
        }

    	.form-inner-div {
        	background-color:white;
        	display: flex;
        	flex-direction: column;
        	width:32%;
        	padding: 20px;
        	border-radius: 10px;
    	}
    	.form-inner-div-button {
        	background-color:white;
        	display: flex;
        	flex-direction: row;
        	width:100%;
        	padding: 20px;
        	border-radius: 10px;
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

    	#edit {
        	background-color: rgb(46, 146, 22);
        	color: white;
    	}
    	#delete {
        	background-color: red;
        	color: white;
    	}
    	
    	#add {
        	width:80%;
        	margin-top: 7px;
        	padding: 12px;
        	outline: none;
        	border-radius: 3px;
        	border: 1px solid black;
        	background-image: linear-gradient(to right, rgb(0, 76, 144, 0.8), black, rgb(0, 76, 144, 0.8));
        	color: white;
        }

    	p {
        	text-align: left;
        	margin-top: 5px;
        	font-weight:300;
    	} 
    	label {
    		font-weight:500;
    	}
    </style>
</head>
<body>
    <h1>Welcome</h1>
    <input type="submit" value="Add Post" id="add" onclick="window.location.href='#'">
    <br><hr style="width: 80%">
    <h2>Recent Posts</h2>
    <div class="form">
    	<div class="form-inner-div">
    		<h1>How Do You Get Up And Go Forward</h1>
    		<p>You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		</p>
    		<hr>
    		<div class="form-inner-div-button">
            	<input type="submit" value="Edit" id="edit" onclick="window.location.href='#'";>
            	<input type="submit" value="Delete" id="delete" onclick="window.location.href='#'";>
          	</div>

    	</div>
    	<div class="form-inner-div">
    		<h1>How Do You Get Up And Go Forward</h1>
    		<p>You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		</p>
    		<hr>
    		<div class="form-inner-div-button">
            	<input type="submit" value="Edit" id="edit" onclick="window.location.href='#'";>
            	<input type="submit" value="Delete" id="delete" onclick="window.location.href='#'";>
          	</div>

    	</div>
    	<div class="form-inner-div">
    		<h1>How Do You Get Up And Go Forward</h1>
    		<p>You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		You will undoubtedly have dreams. Whether you dream of having the perfect house with the perfect car, or you dream of setting down to have a family.
    		</p>
    		<hr>
    		<div class="form-inner-div-button">
            	<input type="submit" value="Edit" id="edit" onclick="window.location.href='#'";>
            	<input type="submit" value="Delete" id="delete" onclick="window.location.href='#'";>
          	</div>
    	</div>
    </div>
</body>
</html>