Ember.Handlebars.registerHelper('formatDate', function(path, options) {
	var rawDate = this.get(path);
	return new Date(rawDate).toLocaleString(); // or whatever format you
												// need...
});

BlogApp = Ember.Application.create({
	LOG_TRANSITIONS : true,
	LOG_BINDINGS : true
});

BlogApp.ApplicationController = Ember.Controller.extend();
BlogApp.ApplicationView = Ember.View.extend();
BlogApp.IndexRoute = Ember.Route.extend({
	redirect : function() {
		this.transitionTo('posts');
	}
});
/*
 * BlogApp.Store = DS.Store.extend({ revision: 11, adapter:
 * DS.RESTAdapter.extend({ url:restBaseUrl }) });
 * 
 * BlogApp.Post = DS.Model.extend({ title : DS.attr('string'), text :
 * DS.attr('string'), postTime : DS.attr('date'), postTimeStr : function(){
 * return $.format.date(new Date(this.get('postTime')), 'dd/MM/yy');
 * }.property('postTime'), becameError:function(){ console.log("Error on Post"); },
 * becameInvalid:function(errors){ console.log("Invalid on Post
 * "+errors.errors.toString()); } });
 */

BlogApp.Post = Ember.Resource.define({
	url : restBaseUrl + '/posts',
	schema : {
		id : Number,
		title : String,
		text : String
	}
})

BlogApp.Router.map(function() {
	this.resource('posts');
	this.resource('post', {
		path : '/posts/:post_id'
	});
	this.route('posts.new', {
		path : '/posts/new'
	});
	this.route('posts.edit', {
		path : '/posts/edit/:post_id'
	});
});

// POST LIST
BlogApp.PostsRoute = Ember.Route.extend({});
BlogApp.PostsController = Ember.ResourceCollection.extend({
	type : BlogApp.Post,
	init : function() {
		return this._super();
	}
});
BlogApp.PostsView = Ember.View.extend();

// POST DETAILS
BlogApp.PostRoute = Ember.Route.extend({
	model : function(params) {
		return BlogApp.Post.create({
			id : params.post_id
		});
	}
});
BlogApp.PostController = Ember.ObjectController.extend({
	needs : 'posts',
	destroyRecord : function() {
		if (window.confirm("Are you sure you want to delete this post?")) {
			this.get('content').destroyResource({
				context : this
			}).done(
					function() {
						this.get('controllers.posts').removeObject(
								this.get('content'));
						this.transitionTo('posts');
					});

		}
	}

});
BlogApp.PostView = Ember.View.extend({});

// POST NEW
BlogApp.PostsNewRoute = Ember.Route.extend({
	model : function(params) {
		return BlogApp.Post.create();
	}
});
BlogApp.PostsNewController = Ember.ObjectController.extend({
	needs : 'posts',
	save : function() {
		var self = this;
		this.get('content').save({
			context : this
		}).done(
				function(data) {
					this.get('controllers.posts').pushObject(
							BlogApp.Post.create(data));
					this.transitionTo('posts');
				});
	},
	cancel : function() {
		this.transitionTo('posts');
	}
});
BlogApp.PostsNewView = Ember.View.extend({});

// POST EDIT
BlogApp.PostsEditRoute = Ember.Route.extend({
	model : function(params) {
		return BlogApp.Post.create({
			id : params.post_id
		});
	}
});
BlogApp.PostsEditController = Ember.ObjectController.extend({
	save : function() {
		this.get('content').save({context : this}).done(function(data) {
			this.transitionTo('post', this.get('content'));
		});
	},
	cancel : function() {
		this.transitionTo('post', this.get('content'));
	}
});
BlogApp.PostsEditView = Ember.View.extend({});

BlogApp.initialize();