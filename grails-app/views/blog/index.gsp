<html>
<head>
	<meta name="layout" content="main"/>
	<r:require module="blog"/>
	<script type="text/javascript">
		var restBaseUrl = "${createLink(uri:'/', absolute:true)[0 .. -2]}";
	</script>
	<script type="text/x-handlebars">
		{{outlet}}
	</script>
	

	
	<as:emberTemplate name="posts">
		<table>
		{{#each post in controller}}
			<tr><td>{{post.title}}</td><td>{{#linkTo post post}}Details{{/linkTo}} </td></tr>
		{{/each}}
		</table>
	</as:emberTemplate>
	<as:emberTemplate name="post">
		{{content.title}}
	</as:emberTemplate>

	
	
	
	
	
	
	
</head>
<body>

</body>
</html>