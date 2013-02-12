package be.arexo.chat

import grails.converters.JSON;

class MessageController {
	def list() {
		render Message.list() as JSON		
	}
	def send() {
		def message = params.message
		def user = session.user
		if(!user){
			response.status = 400
			return render ('')
		}
		
		def messageToSend = new Message(message : message, user_id : user.id)
		user.addToMessages(messageToSend)
		messageToSend.save()
	}
}
