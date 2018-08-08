<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="static/css/stopwatchstyle.css">
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
					<li><a href="/workout_plan/list">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Group</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/stopwatch">Stopwatch</a></li>
					<li ><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<h1 id="timer">00 : 00 . 000</h1>
	<button class="btn btn-primary" id="toggle">Start</button>
	<button  class="btn btn-primary" id="reset">Reset</button>


	<script src="static/js/stopwatch.js"></script>
	<script src="static/js/stopwatchmain.js"></script>
</body>








</html>