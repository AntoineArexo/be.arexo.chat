<html>
<head>
	<meta name="layout" content="main"/>
	<r:require module="blog"/>
	<script type="text/javascript">
		var restBaseUrl = "${createLink(uri:'/', absolute:true)[0 .. -2]}";
	</script>
	<script type="text/x-handlebars">
		{{outlet main}}
	</script>
	

	
	<as:emberTemplate name="posts">
		<table>
		{{#each post in controller}}
			<tr><td>{{post.title}}</td><td>{{#linkTo post post}}Details{{/linkTo}} </td></tr>
		{{/each}}
		</table>
		<br />
		{{#linkTo "posts.new"}}Add a post{{/linkTo}}
	</as:emberTemplate>
	
	<as:emberTemplate name="post">
		<h2>{{content.title}}</h2>
		<p>{{content.text}}</p>
		<br />
		{{#linkTo posts}}Back to posts{{/linkTo}}
		<br />
		
		<br />
		{{#linkTo posts.edit content}}Update{{/linkTo}}
		<a {{action destroyRecord}}>Remove</a>
	</as:emberTemplate>

	
	
	<as:emberTemplate name="posts/new">
		<h2>New post</h2>
		
		
		<form {{action save on="submit"}}>
			<legend>Add a new post</legend>
			<label class="control-label" for="title">Title</label>
			  <div class="controls">
			    {{view Ember.TextField valueBinding="title" id="title" placeholder="Title..." required="true"}}
			  </div>
		
			<label class="control-label" for="text">Text</label>
			  <div class="controls">
			    {{view Ember.TextArea valueBinding="text" id="text" placeholder="Text..." required="true"}}
			  </div>
			  <button type="submit">Create</button>
    		<button class="btn" {{action cancel}}>Cancel</button>
		</form>
	</as:emberTemplate>
	
	<as:emberTemplate name="posts/edit">
		<h2>Update post</h2>
		<form {{action save on="submit"}}>
			<label class="control-label" for="title">Title</label>
			  <div class="controls">
			    {{view Ember.TextField valueBinding="title" id="title" placeholder="Title..." required="true"}}
			  </div>
		
			<label class="control-label" for="text">Text</label>
			  <div class="controls">
			    {{view Ember.TextArea valueBinding="text" id="text" placeholder="Text..." required="true"}}
			  </div>
			  <button type="submit">Save</button>
    		<button class="btn" {{action cancel}}>Cancel</button>
		</form>
	</as:emberTemplate>
	
	
</head>
<body>

</body>
</html>