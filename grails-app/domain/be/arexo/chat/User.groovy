package be.arexo.chat

class User {
	String name
	
	static hasMany = [messages:Message]
	
    static constraints = {
    }
}
