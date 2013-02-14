import grails.converters.JSON;
import be.arexo.chat.Message;
import be.arexo.chat.User;
import be.arexo.chat.Post
import be.arexo.chat.Comment

class BootStrap {

    def init = { servletContext ->
		setDevData()
		registerMarshallers()
    }

	private registerMarshallers() {
		JSON.registerObjectMarshaller(Message) {
			def returnArray = [:]
			returnArray['message'] = it.message
			returnArray['username'] = it.user.name
			return returnArray
		}
	}

	private setDevData() {
		def u = new User(name:"Nico")
		u.save()
		def message = new Message(message:"hello");
		u.addToMessages(message)
		message.save()
                
                // blog's data
                def p = new Post(title: "First post !", text: "I love my new blog !")
                p.save()
                def c = new Comment(text: "Super ton blog !")
                p.addToComments(c)
                c.save()
	}
    def destroy = {
    }
}
