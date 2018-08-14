<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Gym Buddy</title>
<link rel="stylesheet" type="text/css"
	href="/static/css/stopwatchstyle.css">
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link href="/static/css/style.css" rel="stylesheet">

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">

					<li><a href="/show-users">All Users</a></li>
					<li><a href="/workout_plan/">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Group</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/stopwatch">Stopwatch</a></li>
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<h2>${title}</h2>
	<hr>
	<p>
		<a href="/workout_plan/add-item/${workoutId}">Add Exercise</a>
	</p>
	<table>
		<thead>
			<tr>
				<th class="not_mapped_style" style="text-align: center">Exercises</th>
			</tr>
		<tbody>
			<tr>
				<td><label></label></td>
				<c:forEach var="tempexercise" items="${exercises}">
					<tr>
						<td>${tempexercise.name}</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	<h4 id="timer">00 : 00 . 000</h4>
	<button class="btn btn-primary" id="toggle">Start</button>
	<button class="btn btn-primary" id="reset">Reset</button>





	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/stopwatch.js"></script>
	<script src="/static/js/stopwatchmain.js"></script>
</body>
</html>