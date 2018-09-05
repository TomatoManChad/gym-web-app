<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
	<div id="container">
		<div id="content">
			<div class="container" id="welcomediv">
				<div class="jumbotron text-center">
					<h1>Your Workouts</h1>
					<h3>Add, delete and view your own workouts below to
						personalize your own routine</h3>
				</div>
			</div>


			<input type="button" class="btn btn-primary" value="Add Workout"
				onclick="window.location.href='${pageContext.request.contextPath}/workout_plan/add'; return false;"
				class="add-button" /> <br> <br>

			<div class="table-responsive">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th class="not_mapped_style" style="text-align: center">Workout</th>
							<th class="not_mapped_style" style="text-align: center">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempWorkout" items="${workoutPlans}">
							<tr>
								<td class="not_mapped_style" style="text-align: center">${tempWorkout.name}</td>
								<td class="not_mapped_style" style="text-align: center"><a
									href="/workout_plan/view/${tempWorkout.id}">View</a> <br>
									<a href="/workout_plan/delete/${tempWorkout.id}"
									onclick="if(!(confirm('Are you sure you want to delete this Workout?'))) return false">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="/static/js/jquery-1.11.1.mis.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>