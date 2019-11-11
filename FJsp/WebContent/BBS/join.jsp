<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		body{
			background-color: #6DC1F5;
			font-family: calnin
		}
	
		.container{
			
			position:absolute;
			width:500px;
			top:50%;
			left:50%;
			transform: translate(-50%,-50%);
			color: white;
		}
		
		.joinLogo{
			
			font-size: 40px;
			text-align: center;
		}
		
		.ulcl{
			position: relative;
			top: -30px;
			
			list-style: none;	
		} 
		
		.ulcl input{
			width:100%;
			height: 15px;
			border: none;
			outline: none;
			background: none;
			border-bottom: 1px dotted white;
		}
		
		.pcl{
			position: absolute;
			left: 150px;
			font-size: 10px;
		
		}

		li{	
			height:1px;
			font-size: 20px;
			margin: 30px;
			padding: 30px;
		}
		.inputcl{
			position: relative;
			top: -20px;
			left: 115px;
		}

		.subcl{

			border: 1px solid white;
			width: 150px;
			height: 50px;
			outline: none;
			background: none;
			color:white;
		}
		button{
			
			border: 1px solid white;
			width: 150px;
			height: 50px;
			outline: none;
			background: none;
			color:white;
			
		}
		
	</style>
</head>
	

<body>
	<div class="container">
		<div class="joinLogo">J O I N</div>
		<div class="listbox">
	<form method="POST" action="#">
		<ul class="ulcl">
			<li><label for="id">I D</label><input type="text" id="id" name="id">
			<p class="pcl" id="id_check"></p></li>
			
			<li><label for="pw">Password</label><input type="password" id="pw" name="pw">
			<p class="pcl" id="pw_check"></p></li>
			
			<li><label for="pw_e">Password Confirm</label><input type="password" id="pw_c" name="pw_c">
			<p class="pcl" id="pwc_check"></p></li>
			
			<li><label for="name">Name</label><input type="text" id="name" name="name">
			<p class="pcl" id="name_check"></p></li>
			
			<li><label for="email">E-mail</label><input type="text" id="email" name="email"></li>
			<p class="pcl" id="email_check"></p>
			
			<li><label for="num">Phone Number</label><input type="text" id="num" name="num">
			<p class="pcl" id="num_check"></p>
			</li>


		</ul>
		<div class="inputcl">
			<input class="subcl" type="submit" id="join" name="join" value="Sign Up">
			<button id="returnBtn">Back</button>
		</div>
	</form>
	</div>
</div>