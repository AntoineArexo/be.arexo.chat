package be.arexo.chat

import org.joda.time.DateTime;

class Comment {
    
    String text
	DateTime commentTime = new DateTime()
    
    static belongsTo = [post:Post]

    static constraints = {
    }
}
