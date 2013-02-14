package be.arexo.chat

import org.joda.time.DateTime

class Post {
    
    String title
    String text
    DateTime postTime
    
    static hasMany = [comments: Comment]

    static constraints = {
    }
}
