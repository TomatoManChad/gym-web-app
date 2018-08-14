<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Gym Buddy</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
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
					<li><a href="/chat">Chat</a></li>
					<li><a href="/stopwatch">Stopwatch</a></li>
					<li><a href="/logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>
	<h2>${title}</h2>
	<div id="container">
		<form:form action="/workout_plan/add-item/" modelAttribute="${form}"
			method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Exercises: </label></td>
						<td><br> <select name="exerciseId" id="exerciseId">
								<c:forEach var="tempExercise" items="${form.exercises}">
									<option value="${tempExercise.name}">${tempExercise.name}</option>

								</c:forEach>
						</select>
					</tr>
					<td><br> <input type="hidden" name="workoutId"
						value="${workoutId}" /></td>
					<td><br> <input type="submit" value="Add"
						class="btn btn-primary" /></td>

				</tbody>
			</table>
		</form:form>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/workout_plan/list">Back
				to List</a>
		</p>
	</div>
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>