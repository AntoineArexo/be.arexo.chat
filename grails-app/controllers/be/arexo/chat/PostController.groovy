package be.arexo.chat

import grails.converters.JSON

class PostController {
	def show(){
		def id = params.id
		if(id && Post.exists(id)){
			def post = Post.findByName(id)	
			render post as JSON
		}
		else{
			def all = Post.list()
			render all as JSON
		}
	}
	
	def update(){
		def id = params.id
		if(id && Post.exists(id)){
			def p = Post.get(id)
			p.title = params.title
			p.text = params.text
			
			if(p.save()){
				render p as JSON
			}	
		}
	}
	
	def save(){
		def p = new Post(params.title, params.text)
		if(p.save()){
			render p as JSON
		}
	}
	
	def delete(){
		def id = params.id
		if(id && Post.exists(id)){
			def p = Post.get(id)
			
			p.delete(flush:true)
		}
	}
}
