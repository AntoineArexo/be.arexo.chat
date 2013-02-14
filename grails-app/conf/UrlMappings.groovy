class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller: 'chat', action: 'index')
		"500"(view:'/error')
		
		"/post/$id?"(resource:"post"){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
		"/comment/$id?"(resource:"post"){
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
	}
}
