<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title><g:message code="be.arexo.chat.messages.title" /></title>
<script type="text/javascript">
	var restMessageListUrl = "${createLink(controller:'message', action:'list', absolute:true)}"
	var restMessageSendUrl = "${createLink(controller:'message', action:'send', absolute:true)}"
</script>
<r:require module="chat"/>
</head>
<body>
  <div class="body">
  	<h1><g:message code="be.arexo.chat.h1title" /></h1>
  	<h3><g:message code="be.arexo.chat.messages.connectedas" />${ user?.name }</h3>
  	<h3><g:message code="be.arexo.chat.messages.title" /></h3>
  	<table id="messageTable">
  		<thead>
 			<tr>
 				<th><g:message code="be.arexo.chat.messages.list.message" /></th>
 				<th><g:message code="be.arexo.chat.messages.list.user" /></th>
 			</tr>
 		</thead>
 		<tbody>
 			
		</tbody>
  	</table>
  	<p id="errorBox" class="text-error"></p>
  	<g:textField name="message" id="sendMessage"/><br />
  	<button id="send-button"><g:message code="be.arexo.chat.messages.send-button" /></button>
  	<g:link action="logout"><g:message code="be.arexo.chat.messages.logout" /></g:link>
  </div>
</body>
</html>