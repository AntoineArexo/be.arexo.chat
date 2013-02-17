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
			restAdapter.renderMaprest(post, MaprestFormat.JSON)
		}
		else{
			def all = Post.list()
			//render all as JSON
			
			
			restAdapter.renderMapListRest(all,  MaprestFormat.JSON)
			
		}
	}
	
	def update(){
		def id = params.id
		if(id && Post.exists(id)){
			def p = Post.get(id)
			p.properties = params;
			
			if(p.save()){
				def restAdapter = new RestAdapter()
				restAdapter.renderMaprest(p, MaprestFormat.JSON)
			}	
		}
	}
	
	def save(){
		def restAdapter = new RestAdapter()
		println "params : "+params
		def p = new Post(params)
		if(!p.validate()){
			response.status = 422
			return render(p.errors as JSON)
		}
		if(p.save()){
			restAdapter.renderMaprest(p, MaprestFormat.JSON)
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
