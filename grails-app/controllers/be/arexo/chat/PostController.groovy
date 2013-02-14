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
}
