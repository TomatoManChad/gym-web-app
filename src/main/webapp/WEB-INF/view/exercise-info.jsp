<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>Gym Buddy</title>
<link href="../static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link href="static/css/style.css" rel="stylesheet">
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
					<li><a href="/stopwatch">Stopwatch</a></li>
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<h4>${exercise.name}</h4>
	</div>
	<div>${exercise.instructions}</div>
	<br>
	<div>
		<iframe width="560" height="315" src=${exercise.video
			}
			frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>

