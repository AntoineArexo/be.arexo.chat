package be.arexo.chat

import com.appstart.Mapper
import grails.converters.JSON

class TestMapperController {

	def index(){
		def id = params.id
		def mapper = new Mapper()
		if(id && Post.exists(id)){
			def post = Post.get(id)	
			 render mapper.renderMap(post, "post") as JSON
		}
		else{
			def all = Post.list()
			//render all as JSON
			
			
			render mapper.renderMap(all, "posts") as JSON
			
		}
	}
}
