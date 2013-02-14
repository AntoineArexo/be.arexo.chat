package be.arexo.chat

import org.joda.time.DateTime;

class Comment {
    
    String text
	DateTime postTime
    
    static belongsTo = [post:Post]

    static constraints = {
    }
}
