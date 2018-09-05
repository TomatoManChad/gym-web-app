<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div id="wrapper" align=center>
		<div id="header">
			<h2 class="not_mapped_style" style="text-align: center">New
				Workout</h2>
		</div>
		<div id="container">
			<form:form action="saveWorkout" modelAttribute="workout"
				method="POST">
				<input type="hidden" name="userid" value="${userid}" />
				<table>
					<tbody>
						<tr>
							<td class="not_mapped_style" style="text-align: center"><label>workout
									name: </label></td>
							<td><form:input path="name" /></td>
						</tr>
					</tbody>
				</table>
				<br>
				<input type="submit" value="Create" class="btn btn-primary" />
			</form:form>
			<div style=""></div>
			<br>
			<p>
				<a href="${pageContext.request.contextPath}/workout_plan/${userid}">Back
					to List</a>
			</p>
		</div>
	</div>
	<script src="/static/js/jquery-1.11.1.mis.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>
</body>
</html>