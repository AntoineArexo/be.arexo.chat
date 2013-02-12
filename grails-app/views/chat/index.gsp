<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>chat connection</title>
</head>
<body>
  <div class="body">
  	<g:if test="${flash.message }" >
  		<div class="message" role="status" >${flash.message }</div>
  	</g:if>
  	<h3>Please, enter your user-name</h3>
  	<g:form action="login">
	  	<g:textField name="username"/>
	  	<g:submitButton name="submit" value="Join the chat"/>
  	</g:form>
  </div>
</body>
</html>