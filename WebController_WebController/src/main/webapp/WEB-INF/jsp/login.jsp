<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>





<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Portfolio Manager</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #fff;
	background: black;
}
    
.form-control {
	min-height: 41px;
	background: #fff;
	box-shadow: none !important;
	border-color: #e3e3e3;
}
.form-control:focus {
	border-color: #70c5c0;
}
.form-control, .btn {        
	border-radius: 2px;
}
.login-form {
	width: 350px;
	margin: 0 auto;
	padding: 100px 0 30px;		
}
.login-form form {
	color: #7a7a7a;
	border-radius: 2px;
	margin-bottom: 15px;
	font-size: 13px;
	background: #ececec;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;	
	position: relative;	
}
.login-form h2 {
	font-size: 22px;
	margin: 35px 0 25px;
}
.login-form .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -50px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: #70c5c0;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}
.login-form .avatar img {
	width: 100%;
}	
.login-form input[type="checkbox"] {
	position: relative;
	top: 1px;
}
.login-form .btn, .login-form .btn:active {        
	font-size: 16px;
	font-weight: bold;
	background: #70c5c0 !important;
	border: none;
	margin-bottom: 20px;
}
.login-form .btn:hover, .login-form .btn:focus {
	background: #50b8b3 !important;
}    
.login-form a {
	color: #fff;
	text-decoration: underline;
}
.login-form a:hover {
	text-decoration: none;
}
.login-form form a {
	color: #7a7a7a;
	text-decoration: none;
}
.login-form form a:hover {
	text-decoration: underline;
}
.login-form .bottom-action {
	font-size: 14px;
}
.text-center {
    flex: 1;
    justify-content: center;
    align-items: center;
            
    }
    h3 { 
  display: block;
  font-size: 2em;
  margin-top: 3em;
  margin-bottom: 0.67em;
  margin-left: 0;
  margin-right: 0;
  font-weight: italic;
  font: Snell Roundhand, cursive;
}
</style>
</head>
<body>
    <div style="background-image: url('https://images.unsplash.com/photo-1600007283728-22abc97b9318?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');  background-repeat: no-repeat; background-size: cover;">
    
<div class="login-form">
    <form action="/login" method="POST" model="userData" name="loginform">
		<div class="avatar">
			<img src="https://image.flaticon.com/icons/png/128/3135/3135679.png" alt="Avatar">
		</div>
        <div style="https://images.unsplash.com/photo-1607728285423-a94d41a4d2f6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80');">
        <h2 class="text-center">User Login</h2>   
        <div class="form-group">
        	<input type="text" class="form-control"  id="inputName" name="userId" class="form-control"
							placeholder="User Name" required>
        </div>
		<div class="form-group">
		
           <input type="password"  id="inputPassword" name="userPassword" 
							class="form-control" placeholder="Password" required>
        </div>        
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block">Log in</button>
        </div>
        <div class="text-center d-flex justify-content-between mt-4"><p>${errormsg}</u></p></div>
        </div>
        
		
    </form>
    
</div>
    </div>
        <div class="text-center">
      <h3>
      Welcome to the Portfolio Management System by POD-01</h3>
        </div>
</body>
</html>