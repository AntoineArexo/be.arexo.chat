BlogApp = Ember.Application.create({
	LOG_TRANSITIONS: true
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
		this.resource('post', {path:':post_id'});
	});
	//this.resource('post', { path: '/posts/:post_id' });
	
});



BlogApp.PostsRoute = Ember.Route.extend({
	model : function(params){
		return BlogApp.Post.find();
	}
});
BlogApp.PostsController = Ember.ArrayController.extend();
BlogApp.PostsView = Ember.View.extend();



BlogApp.PostRoute = Ember.Route.extend({
	/*model : function(params){
		console.log('in post route, with post_id '+params.post_id);
		return BlogApp.Post.find(params.post_id);
	}*/
});
BlogApp.PostController = Ember.ObjectController.extend();
BlogApp.PostView = Ember.View.extend();









BlogApp.initialize();