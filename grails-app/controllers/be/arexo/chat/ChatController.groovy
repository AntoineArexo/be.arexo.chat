package be.arexo.chat

class ChatController {
	def index() {
		if (session?.user) {
			redirect(action: "messages")
		}
	}
	
	def messages() {
		if (!session?.user) {
			redirect(action: "index")
		}
		[user: session.user]
	}
	
	def login() {
		def username = params.username
		def u = User.findByName(username)
		if (!u) {
			u = new User(name: username)
			u.save(flush:true, failOnError:true)
		}
		session.user = u
		redirect(action: "messages")
	}
	
	def logout() {
		session.user = null
		redirect(action: "index")
	}
}
