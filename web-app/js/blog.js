BlogApp = Ember.Application.create({
	LOG_TRANSITIONS: true, 
	LOG_BINDINGS:true
});

BlogApp.ApplicationController = Ember.Controller.extend();
BlogApp.ApplicationView = Ember.View.extend();
BlogApp.IndexRoute = Ember.Route.extend({
	redirect:function(){
		this.transitionTo('posts');
	}
});

BlogApp.Store = DS.Store.extend({
	revision: 11,
	adapter: DS.RESTAdapter.extend({
		url:restBaseUrl
	})
});

BlogApp.Post = DS.Model.extend({
	title : DS.attr('string'),
	text : DS.attr('string')/*,
	postTime : DS.attr('date')*/
});



BlogApp.Router.map(function(){
	this.resource('posts', function(){
		
	});
	this.resource('post', {path:'/post/:post_id'});
	//this.resource('post', { path: '/posts/:post_id' });
	
});



BlogApp.PostsRoute = Ember.Route.extend({
	model : function(params){
		return BlogApp.Post.find();
	}
});
BlogApp.PostsController = Ember.ArrayController.extend();
BlogApp.PostsView = Ember.View.extend();



BlogApp.PostIndexRoute = Ember.Route.extend({
	/*setupController:function(controller){
		console.log("PostRoute setup controller "+controller);
	},*/
	model : function(params){
		console.log('in post route, with post_id '+params.post_id);
		return BlogApp.Post.find(params.post_id);
	}
});
BlogApp.PostIndexController = Ember.ObjectController.extend();
BlogApp.PostIndexView = Ember.View.extend();









BlogApp.initialize();