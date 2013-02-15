package be.arexo.chat

import com.appstart.MaprestFormat;
import com.appstart.RestAdapter;

import grails.converters.JSON

class PostController {
	def show(){
		def id = params.id
		def restAdapter = new RestAdapter()
		if(id && Post.exists(id)){
			def post = Post.get(id)	
			restAdapter.renderMaprest(post, MaprestFormat.JSON, "post")
		}
		else{
			def all = Post.list()
			//render all as JSON
			
			
			restAdapter.renderMapListRest(all,  MaprestFormat.JSON, "posts")
			
		}
	}
	
	def update(){
		def id = params.id
		if(id && Post.exists(id)){
			def p = Post.get(id)
			p.properties = params.post;
			
			if(p.save()){
				def restAdapter = new RestAdapter()
				restAdapter.renderMaprest(p, MaprestFormat.JSON, "post")
			}	
		}
	}
	
	def save(){
		def restAdapter = new RestAdapter()
		println "params : "+params
		def p = new Post(params.post)
		if(!p.validate()){
			response.status = 422
			return render(p.errors as JSON)
		}
		if(p.save()){
			
			restAdapter.renderMaprest(p, MaprestFormat.JSON, "post")
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
