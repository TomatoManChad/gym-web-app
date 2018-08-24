<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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

					<!-- <li><a href="/show-users">All Users</a></li> -->
					<li><a href="/workout_plan/">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Group</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="header">
			<h2>New Workout</h2>
		</div>
		<div id="container">
			<form:form action="saveWorkoutPlan" modelAttribute="workout"
				method="POST">
				<form:hidden path="id" />
				<table>
					<tbody>
						<tr>
							<td><label>workout name: </label></td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><br> <label>Add exercises: </label></td>

							<td><br> <select id="exerciselist">
									<c:forEach var="tempExercise" items="${exercises}">
										<option value="${tempExercise.name}">${tempExercise.name}</option>
									</c:forEach>
							</select>
						</tr>
						<tr>
							<td><button type="button" onClick="getSelectValue();">Add</button>
						</tr>
						<tr>
							<td><label id="tester"> </label></td>

							<td><br> <input type="submit" value="Create"
								class="btn btn-primary" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style=""></div>
			<p>
				<a href="${pageContext.request.contextPath}/workout_plan/list">Back
					to List</a>
			</p>
		</div>
	</div>

	<form:form action="addExerciseToWorkout" modelAttribute="exercise"
		method="POST">

		<table>
			<tbody>
				<tr>
					<td><label>Exercise: </label></td>
					<td id="plzwork"></td>
				</tr>
			</tbody>
		</table>

	</form:form>

	<script>
		function getSelectValue() {
			var selectedValue = document.getElementById("exerciselist").value;
			console.log(selectedValue);
			//document.write(selectedValue);
			document.getElementById("tester").innerHTML += selectedValue
					+ "<br />";
		}
	</script>
</body>
</html>