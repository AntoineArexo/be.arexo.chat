package be.arexo.chat

import com.appstart.Mapper

import grails.converters.JSON

class PostController {
	def show(){
		def id = params.id
		if(id && Post.exists(id)){
			def post = Post.get(id)
            render post as JSON
		}
		else{
			def all = Post.findAll()
			//render all as JSON
            render all as JSON
		}
	}
	
	def update(){
		def id = params.id
		if(id && Post.exists(id)){
			def p = Post.get(id)
			p.properties = params;
			
			if(p.save()){
                render p as JSON
			}	
		}
	}
	
	def save(){
		println "params : "+params
		def p = new Post(params)
		if(!p.validate()){
			response.status = 422
			return p.errors as JSON
		}
		if(p.save()){
            render p as JSON
		}
	}
	
	def delete(){
		def id = params.id
		if(id && Post.exists(id)){
			def p = Post.get(id)
		
			p.delete(flush:true)
			render([] as JSON)
		}
	}
}
