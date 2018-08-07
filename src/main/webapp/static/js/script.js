function connect(){
	var socket = new SockJS('/chat-messaging');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		console.log("connected: " + frame);
		stompClient.subscribe('/chat/messages', function(response) {
			var data = JSON.parse(response.body);
			draw("left", data.message);
			
		});
	});

	alert("Connected");
}

function disconnect(){
	stompClient.disconnect();
	alert("Disconnected");
}

function draw(side, text) {
	console.log("drawing...");
	var $message;
	$message=$($('.message_template').clone().html());
	$message.addClass(side).find('.text').html(text);
	$('.messages').append($message);
	return setTimeout(function() {
		return $message.addClass('appeared');
	}, 0);
}

function sendMessage(){
	stompClient.send("/app/message", {}, JSON.stringify({'message': $("#message_input_value").val()}));
	document.getElementById("message_input_value").value= "";

}

   

