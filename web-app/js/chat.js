// Send message
function sendMessage(){
	// Hide the error box
	$("#errorBox").hide();
	
	// Ajax request
	$.ajax({
		url: restMessageSendUrl,
		type: 'POST',
		data: "message="+$("#sendMessage").val(),
		success: function(event) {
			// Clean form
			$("#sendMessage").val("");
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
}

// Refresh messages list
function refreshMessages() {
	$.ajax({
		url: restMessageListUrl,
		dataType: 'json',
		success: function(event) {
			displayMessages(event);
		},
		complete: function(event) {
			
		},
		error: function(event) {
			console.log(event.message);
		}
	});
}

// Display Message in the table
function displayMessages(messages) {
	// Remove messages from html
	$('#messageTable tbody').html('');
	// Fill the table messages
	$.each(messages, function(index, message){
		var line = $('#messageTable ').append('<tr><td>'+message.username+'</td><td>'+message.message+'</td></tr>');
		
	});
}

// Create timer to refresh messages
var timerPolingMessage = $.timer(function () {refreshMessages();}, 2000, false);

$(document).ready(function(){
	// Run the timer when loaded
	timerPolingMessage.play(true);
	$("#send-button").click(function(event) {
		sendMessage();
	});
});