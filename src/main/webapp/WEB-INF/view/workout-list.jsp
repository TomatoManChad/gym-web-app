<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>Workouts</title>
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
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="header">
			<h2>the workout plans</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" class="btn btn-primary" value="Add Workout"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" /> <br>
			<br>
			<div class="table-responsive">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th class="not_mapped_style" style="text-align: center">Workout</th>
							<th class="not_mapped_style" style="text-align: center">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempWorkout" items="${workouts}">
							<tr>
								<td>${tempWorkout.name}</td>
								<c:url var="ViewLink" value="/workout_plan/view">
									<c:param name="workout" value="${tempWorkout.id}" />
								</c:url>
								<c:url var="deleteLink" value="/workout_plan/delete">
									<c:param name="workout" value="${tempWorkout.id}" />
								</c:url>

								<td><a href="${viewLink}">View</a> <br>
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this Workout?'))) return false">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>
