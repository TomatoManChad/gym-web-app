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
					<li><a href="/workout_plan/list">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Group</a></li>
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
					<td>${tempExercise.name}<!-- construct an "delete" link with exercise id-->
						<c:url var="deleteLink" value="/exercise/delete">
							<c:param name="exercise" value="${tempExercise.name}" />
						</c:url> <!--  display the update link -->
						<c:url var="viewLink" value="/exercise/${tempExercise.name}">
							
							<c:forEach var="temp1Exercise" items="${exerciseinfo}">
							
							</c:forEach>
						</c:url>
					<!--  <td><a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete this Exercise?'))) return false">Delete</a>-->
					</td>
					<td><a href="${viewLink}">View</a>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>