<!DOCTYPE html>
<html>
<head>
<title>GymBuddy</title>
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">


</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Gym Buddy</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					
					<li><a href="/show-users">All Users</a></li>
					<li><a href="/workout_plan/list">Your Workouts</a></li>
					<li><a href="/exercise/list">Exercises</a></li>
					<li><a href="/musclegroup/list">Muscle Groups</a></li>
					<li><a href="/chat">Chat</a></li>
					<li><a href="/stopwatch">Stopwatch</a></li>
					<li><a href="/logout">Logout</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<h1>chat</h1>
	<div class="chat_window">
		<div class="top_menu">
			<div class="title">Chat</div>
		</div>
		<ul class="messages"></ul>
		<div class="bottom_wrapper clearfix">
			<div class="message_input_wrapper">
				<input id="message_input_value" class="message_input"
					placeholder="Type your message here..." />
			</div>
			<div class="sender">
				<button class="btn btn-primary" onclick="sendMessage()" class="text">Send</button>
			</div>
			<button class="btn btn-primary" onclick="connect()">Connect
				to chat</button>
			<button class="btn btn-primary" onclick="disconnect()">Disconnect
				from chat</button>
		</div>
	</div>
	<div id="message_template" class="message_template">
		<li class="message">
			<div class="text_wrapper">
				<div class="text"></div>
			</div>
		</li>
	</div>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script src="static/js/script.js"></script>
</body>
</html>