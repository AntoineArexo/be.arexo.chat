package be.arexo.chat

class Message implements Serializable {
	String message
		
	static belongsTo = [user:User]
	
    static constraints = {
    }
}
