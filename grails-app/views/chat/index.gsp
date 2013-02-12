<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title><g:message code="be.arexo.chat.index.title" /></title>
</head>
<body>
  <div class="body">
  	<h1><g:message code="be.arexo.chat.h1title" /></h1>
  	<h3><g:message code="be.arexo.chat.index.indication" /></h3>
  	<g:form action="login">
	  	<g:textField name="username"/>
	  	<g:submitButton name="login-button" value="${message(code : 'be.arexo.chat.index.login-button')}"/>
  	</g:form>
  </div>
</body>
</html>