package com.appstart

class AppStartTagLib {
	static namespace = "as"
	
	
	def layoutLink = { attrs, body ->
		
		
		
	}
	
	def layoutAppStart = {
		out << '<div id="appstart_ember_root_element"></div>'
	}
	
	/**
	 * Creates an ember handlebar
	 *
	 * @attr name REQUIRED name of the template
	 */
	def emberTemplate = { attrs, body -> 
		
		out << '<script type="text/x-handlebars" data-template-name="'+attrs.name+'">'
		out << body()
	    out << '</script>'
			
	}
	
	
	 
}
