package be.arexo.chat

class Message {
	String message
		
	static belongsTo = [user:User]
	
    static constraints = {
    }
}
