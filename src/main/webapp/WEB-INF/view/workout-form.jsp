<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>New Workout
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>New Workout</h2>
		</div>
		<div id="container">
			<h3>Save Workout</h3>
			<form:form action="saveWorkoutPlan" modelAttribute="workout"
				method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>workout name: </label></td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Create" class="save" /></td>
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
</body>
</html>