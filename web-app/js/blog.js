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
	this.resource('posts');
	this.resource('post', {path:'/posts/:post_id'});
	this.route('posts.new', {path: '/posts/new'});
	this.route('posts.edit', {path:'/posts/edit/:post_id'});
});



BlogApp.PostsRoute = Ember.Route.extend({
	model : function(params){
		return BlogApp.Post.find();
	}
	/*renderTemplate: function() {
	    this.render({ into: 'application' });
	  }*/
});
BlogApp.PostsController = Ember.ArrayController.extend({

});
BlogApp.PostsView = Ember.View.extend();



BlogApp.PostRoute = Ember.Route.extend({
});
BlogApp.PostController = Ember.ObjectController.extend({
	
	destroyRecord: function() {
	    if (window.confirm("Are you sure you want to delete this post?")) {
	      this.get('content').deleteRecord();
	      this.get('store').commit();

	      // return to the main contacts listing page
	      this.get('target.router').transitionTo('posts');
	    }
	  }
	
});
BlogApp.PostView = Ember.View.extend({});

BlogApp.PostsNewRoute = Ember.Route.extend({
	model: function() {
	    // Because we are maintaining a transaction locally in the controller for editing,
	    // the new record needs to be created in the controller.
	    return null;
	  },

	  setupController: function(controller) {
	    controller.startEditing();
	  },

	  exit: function() {
	    this._super();
	    this.controllerFor('posts.new').stopEditing();
	  }
});
BlogApp.PostsNewController = Ember.ObjectController.extend({
	startEditing: function() {
	    // create a new record on a local transaction
	    this.transaction = this.get('store').transaction();
	    this.set('content', this.transaction.createRecord(BlogApp.Post, {}));
	  },

	  stopEditing: function() {
	    // rollback the local transaction if it hasn't already been cleared
	    if (this.transaction) {
	      this.transaction.rollback();
	      this.transaction = null;
	    }
	  },
	  transitionAfterSave: function() {
		    // when creating new records, it's necessary to wait for the record to be assigned
		    // an id before we can transition to its route (which depends on its id)
		    if (this.get('content.id')) {
		      this.transitionTo('post', this.get('content'));
		    }
		  }.observes('content.id'),
	save: function() {
	    // commit and then clear the local transaction
	    this.transaction.commit();
	    this.transaction = null;
	  },
	cancel: function() {
		this.stopEditing();
	    this.transitionTo('posts');
	}
});
BlogApp.PostsNewView = Ember.View.extend({});


BlogApp.PostsEditRoute = Ember.Route.extend({
	model : function(params){
		return BlogApp.Post.find(params.post_id);
	},
	setupController: function(controller) {
	    controller.startEditing();
	  },

	  exit: function() {
	    this._super();
	    this.controllerFor('posts.edit').stopEditing();
	  }
});
BlogApp.PostsEditController = Ember.ObjectController.extend({
	startEditing: function() {
	    
		var post = this.get('content');
	    var transaction = post.get('store').transaction();
	    transaction.add(post);
	    this.transaction = transaction;
		// create a new record on a local transaction
	    
	    
	    //this.set('content', this.transaction.createRecord(BlogApp.Post, {}));
	  },

	  stopEditing: function() {
	    // rollback the local transaction if it hasn't already been cleared
	    if (this.transaction) {
	      this.transaction.rollback();
	      this.transaction = null;
	    }
	  },
	
	save: function() {
	    // commit and then clear the local transaction
	    this.transaction.commit();
	    this.transaction = null;
	    this.transitionTo('post', this.get('content'));
	  },
	  cancel: function() {
		    this.stopEditing();
		    this.transitionTo('post', this.get('content'));
	  }
	
});
BlogApp.PostsEditView = Ember.View.extend({});


BlogApp.initialize();