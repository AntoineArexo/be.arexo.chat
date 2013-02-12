import grails.converters.JSON;
import be.arexo.chat.Message;
import be.arexo.chat.User;

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
	}
    def destroy = {
    }
}
