// Send message
$("#send-button").click(function(event) {
	// Hide the error box
	$("#errorBox").hide();
	
	// Ajax request
	$.ajax({
		url: restMessageSendUrl,
		type: POST,
		data: "message="+$("#sendMessage").value,
		success: function(event) {
			// Clean form
			$("#sendMessage").value("");
			// Display messages received
			displayMessages(event);
		},
		complete: function(event) {
			
		},
		error: function(event) {
			// Display an error in error box
			$("#errorBox").html("Une erreur est survenue durant l'envoi du message.");
			$("#errorBox").show();
		}
	});
});

// Refresh messages list
function refreshMessages() {
	$.ajax({
		url: restMessageListUrl,
		dataType: JSON,
		success: function(event) {
			displayMessages(event);
		},
		complete: function(event) {
			
		},
		error: function(event) {
			
		}
	});
}

// Display Message in the table
function displayMessages(messages) {
	// Remove messages from html
	$('#messageTable tbody').html('');
	// Fill the table messages
	$.each(messages, function(message){
		var line = $('#messageTable tbody').add('tr');
		line.add('td').add(message.username);
		line.add('td').add(message.message);
	});
}

// Create timer to refresh messages
var timerPolingMessage = $.timer(function () {refreshMessages();}, 2000, false);

$(document).ready(function(){
	// Run the timer when loaded
	timerPolingMessage.play(true);
});