package be.arexo.chat

import com.appstart.Mapper
import com.appstart.MapperOption
import grails.converters.JSON

class TestMapperController {

	def index(){
		def id = params.id
		if(id && Post.exists(id)){
			def post = Post.get(id)	
			 render Mapper.getMap(post, [:]) as JSON
		}
		else{
			def all = Post.list()
			//render all as JSON
			
			
            render Mapper.getMap(all, [:]) as JSON
			
		}
	}
}
