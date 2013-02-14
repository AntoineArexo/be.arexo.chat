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
		{{#each post in controller}}
			{{post.title}}
		{{/each}}
	</as:emberTemplate>
	
</head>
<body>

</body>
</html>