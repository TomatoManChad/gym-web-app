<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gym Buddy</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link  href="/static/css/style.css" rel="stylesheet" type="text/css">
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
					<li><a href="/logout">Logout</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>View Exercises By Muscle Group</h1>
		</div>

	</div>
	<table class="table table-striped table-bordered">
		<c:forEach var="tempMuscleGroup" items="${musclegroups}">
			<tr>
				<td class="not_mapped_style" style="text-align: center"><a
					href="${pageContext.request.contextPath}/musclegroup/list/${tempMuscleGroup.name}/">
						${tempMuscleGroup.name} </a><br> ${tempMuscleGroup.description}<br>
	
					<img id="imageId" class="muscleImage" src="" height="400" width="600" alt="${tempMuscleGroup.name} image" />
					</td>
					
			</tr>
			<script type="text/javascript">
				console.log("${tempMuscleGroup.name}");

				if ("${tempMuscleGroup.name}" == "Abdominals") {
					document.getElementsByClassName("muscleImage")[0].src = "/static/images/abs.jpg";

				} else if ("${tempMuscleGroup.name}" == "Biceps") {
					document.getElementsByClassName("muscleImage")[1].src = "/static/images/bicep.jpg";
					console.log("INSIDE BICSEPS" + "${tempMuscleGroup.name}");
				} else if ("${tempMuscleGroup.name}" == "Calves") {
					document.getElementsByClassName("muscleImage")[2].src = "/static/images/calves.jpg";

				} else if ("${tempMuscleGroup.name}" == "Chest") {
					document.getElementsByClassName("muscleImage")[3].src = "/static/images/chest.jpg";

				} else if ("${tempMuscleGroup.name}" == "Forearms") {
					document.getElementsByClassName("muscleImage")[4].src = "/static/images/forearms.jpg";
				} else if ("${tempMuscleGroup.name}" == "Quads") {
					document.getElementsByClassName("muscleImage")[5].src = "/static/images/quads.jpg";

				} else if ("${tempMuscleGroup.name}" == "Shoulders") {
					document.getElementsByClassName("muscleImage")[6].src = "/static/images/shoulder.jpg";
				} else if ("${tempMuscleGroup.name}" == "Traps") {
					document.getElementsByClassName("muscleImage")[7].src = "/static/images/traps.jpg";
				}
			</script>
		</c:forEach>
	</table>

	<script src="/static/js/jquery-1.11.1.mis.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>



</body>

</html>


