class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: 'chat', action: 'index')
		"500"(view:'/error')
		
		"/posts/$id?"(resource:"post")
		
		"/comment/$id?"(resource:"comment")
	}
}
