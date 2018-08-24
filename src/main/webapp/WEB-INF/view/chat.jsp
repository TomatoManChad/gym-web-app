<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Gym Buddy</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="/maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
<link rel="stylesheet" href="static/css/style.css" />
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
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>

	<div id="username-page">
		<div class="username-page-container">
			<h1 class="title">Type your username</h1>
			<form id="usernameForm" name="usernameForm">
				<div class="form-group">
					<input type="text" id="name" placeholder="Username"
						autocomplete="off" class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Start
						Chatting</button>
				</div>
			</form>
		</div>
	</div>

	<div id="chat-page" class="hidden">
		<div class="chat-container">
			<div class="chat-header">
				<h2>GymBuddy Chat</h2>
			</div>
			<div class="connecting">Connecting...</div>
			<ul id="messageArea">

			</ul>
			<form id="messageForm" name="messageForm">
				<div class="form-group">
					<div class="input-group clearfix">
						<input type="text" id="message" placeholder="Type a message..."
							autocomplete="off" class="form-control" size="70" />
						<button type="submit" class="primary">Send</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="/static/js/script.js"></script>
</body>
</html>