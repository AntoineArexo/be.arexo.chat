modules = {
    application {
        resource url:'js/application.js'
    }
	jqueryTimer {
		dependsOn 'jquery'
		resource url:'js/jquery.timer.js'
	}
	
	jqueryDateFormat {
		dependsOn 'jquery'
		resource url:'js/jquery/jquery.dateformat.js'
	}
	chat {
		dependsOn 'jquery, jqueryTimer'
		resource url:'js/chat.js'
	}

	
	ember {
		dependsOn 'jquery'
		defaultBundle false
		resource url:'js/ember/handlebars.js'
		resource url:'js/ember/ember.js'
		resource url:'js/ember/ember.data.js'
	}
	
	
	blog {
		dependsOn 'ember, jqueryDateFormat'
		defaultBundle false
		resource url:'js/blog.js'
	}
	
}
