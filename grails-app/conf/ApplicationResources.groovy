modules = {
    application {
        resource url:'js/application.js'
    }
	jqueryTimer {
		dependsOn 'jquery'
		resource url:'js/jquery.timer.js'
	}
	chat {
		dependsOn 'jquery, jqueryTimer'
		resource url:'js/chat.js'
	}
}