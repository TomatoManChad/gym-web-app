<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List all Exercises</title>
</head>
<body>
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