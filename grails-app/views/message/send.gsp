<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title><g:message code="message.send.title" /></title>
</head>
<body>
  <div class="body">
  	<h1><g:message code="be.arexo.chat.h1title" /></h1>
  	<h3><g:message code="message.send.indication" /></h3>
  	<g:form action="send">
  		<g:textField name="message"/>
	  	<g:submitButton name="send-button" value="${message(code : 'message.send.send-button')}"/>
  	</g:form>
  </div>
</body>
</html>