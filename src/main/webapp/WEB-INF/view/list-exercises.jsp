<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gym Buddy</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="/maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link href="/static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<!-- <li><a href="/show-users">All Users</a></li> -->
					<li><a href="/workout_plan/${userid}">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Group</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
		<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>View All Exercises</h1>
			<p>Browse a list of all exercises available on the website</p>
		</div>
	</div>
	
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th class="not_mapped_style" style="text-align: center">Exercise Name</th>
			</tr>
		</thead>

		<c:forEach var="tempExercise" items="${exercises}">
			<tr>
				<td class="not_mapped_style" style="text-align: center"><a href="/exercise/${tempExercise.name}">${tempExercise.name}</a>
				</td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>