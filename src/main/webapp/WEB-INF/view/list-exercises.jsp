<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List all Exercises</title>
<link href="../static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<li><a href="/show-users">All Users</a></li>
					<li><a href="/workout_plan">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Group</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/stopwatch">Stopwatch</a></li>
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<h2>All Exercises</h2>
	<table>
		<tr>
			<th>Exercise name</th>
			<c:forEach var="tempExercise" items="${exercises}">
				<tr>
					<td><a href="/exercise/${tempExercise.name}">${tempExercise.name}</a>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>