package be.arexo.chat

import org.joda.time.DateTime

class Post {
    
    String title
    String text
    DateTime postTime = new DateTime()
    
    static hasMany = [comments: Comment]

    static constraints = {
    }
	
	def transformToMap(Boolean plurals, Map options){
            if (plurals) {
                [id:id,"title":title, text:text]
            }
            else {
                [id:id,"title":title, text:text, comments:comments.collect{it.id}]
            }
	}
        def getRootName(Boolean plurals, Map options) {
            return plurals?"posts":"post"
        }
	def mapDependencies(Boolean plurals, Map options){
            if (plurals) {return [:]}
            return [(Comment) : comments.collect{it.id}]
        }
}
