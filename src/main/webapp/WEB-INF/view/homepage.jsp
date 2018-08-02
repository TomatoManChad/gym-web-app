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
 <link rel="stylesheet" href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
 <link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/homwe" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/workout_plan/list">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/logout">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	
	
	
		<div class="container" id="homediv">
			<div class="jumbotron text-center">
				<h1>Hello, ${user.userName}</h1>
				<h3></h3>
			</div>
		</div>
	
	<c:choose>
		<c:when test="${mode=='ALL_USERS'}">
		<div class="container text-center" id ="tasksDiv">
			<h3>All Users</h3>
			<hr>
			<p>Send automated messages to an online gym friend to let them know your about to start your gym workout</p>
			<div class ="table-responsive">
				<table class = "table table-striped table-bordered">
					<thead>
					<tr>
						<th class="not_mapped_style" style="text-align:center">Id</th>
						<th class="not_mapped_style" style="text-align:center">Username</th>
						<th class="not_mapped_style" style="text-align:center">Message</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var ="user" items="${users}">
						<tr>
						<td>${user.id}</td>
						<td>${user.userName}</td>
						<td><a href="/message-user?email=${user.email}"onclick="alert('Message Sent')"><i class="fas fa-comments fa-2x"></i></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</c:when>
	</c:choose>
	
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>