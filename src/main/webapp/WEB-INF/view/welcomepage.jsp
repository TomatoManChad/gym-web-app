<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>GymBuddy</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/workout_plan/list">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
	<c:when test="${mode=='MODE_HOME'}">
		<div class="container" id="homediv">
			<div class="jumbotron text-center">
				<h1>Welcome to Gym Buddy</h1>
				<h3>An online workout planner to help you organise your gym
					activities</h3>
			</div>
		</div>
	</c:when>
	
	<c:when test="${mode=='MODE_REGISTER'}">
		<div class="container text-center">
			<h3>New Registration</h3>
			<hr>
			<form class="form-horizontal" method="POST" action="save-user">
				<input type="hidden" name="id" value="${user.id}" />
				<div class="form-group">
					<label class="control-label col-md-3">Username</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="userName"
							value="${user.userName}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">First Name</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="firstName"
							value="${user.firstName}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Last Name</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="lastName"
							value="${user.lastName}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Email</label>
					<div class="col-md-4">
						<input type="text" class="form-control" name="email"
							value="${user.email}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Password</label>
					<div class="col-md-4">
						<input type="password" class="form-control" name="passWord"
							value="${user.passWord}" />
					</div>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Register" />
				</div>
			</form>
		</div>
		</c:when>
		
		<c:when test="${mode=='ALL_USERS'}">
		<div class="container text-center" id ="tasksDiv">
			<h3>All Users</h3>
			<hr>
			<p>Send automated messages to an online gym friend to let them know your about to start your gym workout</p>
			<div class ="table-responsive">
				<table class = "table table-striped table-bordered">
					<thread>
					<tr>
						<th>Id</th>
						<th>UserName</th>
						<th>Message</th>
					</tr>
					</thread>
					<tbody>
					<c:forEach var ="user" items="${users}">
						<tr>
						<td>${user.id}</td>
						<td>${user.userName}</td>
						<td><a href="/message-user?email=${user.email}"onclick="alert('Message Sent')"><span class="glyphicon glyphicon-envelope"></span></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</c:when>
		
		<c:when test="${mode=='MODE_LOGIN'}">
		<div class="container text-center">
			<h3>User Login</h3>
			<hr>
			<form class="form-horizontal" method="POST" action="login-user">
				<input type="hidden" name="id" value="${user.id}" />
				<div class="form-group">
					<label class="control-label col-md-3">Username</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="userName"
							value="${user.userName}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Password</label>
					<div class="col-md-4">
						<input type="password" class="form-control" name="passWord"
							value="${user.passWord}" />
					</div>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Login" />
				</div>
			</form>
			</div>
		</c:when>
	</c:choose>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>