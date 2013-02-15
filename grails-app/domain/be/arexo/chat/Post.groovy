package be.arexo.chat

import org.joda.time.DateTime

class Post {
    
    String title
    String text
    DateTime postTime = new DateTime()
    
    static hasMany = [comments: Comment]

    static constraints = {
    }
	
	def transformToMap(){
		[id:id,"title":title, text:text, comments:comments.collect{it.id}]
	}
	
}
