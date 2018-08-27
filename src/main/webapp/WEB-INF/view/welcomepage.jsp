<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Gym Buddy</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/register">New Registration</a></li>
					<li><a href="/login">Login</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode=='MODE_WELCOME'}">
			<div class="container" id="welcomediv">
				<div class="jumbotron text-center">
					<h1>Welcome to Gym Buddy</h1>
					<h3>An online workout planner to help you organise your gym
						activities</h3>
				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_REGISTER'}">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
			
					<input type="hidden" name="id" value="${user.id}" />
						<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<c:out value="${error}"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="userName"
								value="${user.userName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="firstName"
								value="${user.firstName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="lastName"
								value="${user.lastName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="email"
								value="${user.email}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-5">
							<input type="password" class="form-control" name="passWord"
								value="${user.passWord}" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_LOGIN'}">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="login-user">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<c:out value="${error}"></c:out>
						</div>
					</c:if>

					<div class="form-group">

						<label class="control-label col-md-4"><i
							class="fas fa-user fa-2x"></i></label>
						<div class="col-md-4">
							<input type="text" class="form-control" name="userName"
								placeholder="Enter Username" value="${user.userName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4"><i
							class="fas fa-key fa-2x"></i></label>
						<div class="col-md-4">
							<input type="password" class="form-control" name="passWord"
								placeholder="Enter password" value="${user.passWord}" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>