<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<h2>Muscle Groups</h2>

<table>
	<c:forEach var="tempMuscleGroup" items="${musclegroups}">
		<tr>
			<td>${tempMuscleGroup.name}
		</tr>
	</c:forEach>

</table>
<body>

</body>
</html>


