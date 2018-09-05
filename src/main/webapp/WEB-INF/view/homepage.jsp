<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Gym Buddy</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="/maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link href="/static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

				<!-- 	<li><a href="/show-users">All Users</a></li> -->
					<li><a href="/workout_plan/${userid}">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Groups</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Hello, ${username} ${userid}</h1>
			<h3></h3>
		</div>
		
	</div>
<h3 align="center">Find a Gym</h3>
<p align="center">right click on any location on the map to find gyms in new areas</p>
	<div id="map"></div>

	<script src="/static/js/jquery-1.11.1.mis.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/gym_map.js"></script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC8FbdCcK-aR66UEj60bYD-T8p7ZZY6XCw&libraries=places&callback=initMap"
		type="text/javascript"></script>
</body>
</html>