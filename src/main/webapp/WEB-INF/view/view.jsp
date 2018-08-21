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
	href="/maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
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
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<h2 align=center>${title}</h2>
	<hr>
	<p align=center>
		<a href="/workout_plan/add-item/${workoutId}">Add New Exercise</a>
	</p>
	<div class="table-responsive">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th class="not_mapped_style" style="text-align: center">Exercises</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempexercise" items="${exercises}">
					<tr>
						<td class="not_mapped_style" style="text-align: center">${tempexercise.name}</td>
					</tr>
				</c:forEach>
					</tbody>
				</table>
			</div>
			
<br>

	<h3 align=center>Stopwatch</h3>
	<p align=center>Time your workouts and rests between each exercise to help keep track of things</p>
	<p  align=center id="timer">00 : 00 . 000</p>
	<div style="text-align:center;">
	<button class="btn btn-primary" id="toggle">Start</button>
	<button class="btn btn-primary" id="reset">Reset</button>
</div>




	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
	<script src="/static/js/stopwatch.js"></script>
	<script src="/static/js/stopwatchmain.js"></script>
</body>
</html>