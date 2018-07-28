<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<Title>Workouts</Title>

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>the workout plans</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add Workout"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<table>
				<tr>
					<th>Workout</th>
					<th></th>
					<th>Action</th>
				</tr>
				<!-- loop over to print workouts -->
				<c:forEach var="tempWorkout" items="${workouts}">
					<tr>
						<td>${tempWorkout.name}</td>
						<!-- construct an "view" link with workout id -->
						<c:url var="ViewLink" value="/workout_plan/view">
							<c:param name="workout" value="${tempWorkout.id}" />
						</c:url>
						<!-- construct an "delete" link with workout id -->
						<c:url var="deleteLink" value="/workout_plan/delete">
							<c:param name="workout" value="${tempWorkout.id}" />
						</c:url>
						<!--  display the update link -->

						<td> </td>

						<td><a href="${viewLink}">View</a> 
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this Workout?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>
