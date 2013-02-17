package be.arexo.chat

import org.joda.time.DateTime;

class Comment {
    
    String text
	DateTime commentTime = new DateTime()
    
    static belongsTo = [post:Post]

    static constraints = {
    }
    
	def transformToMap(plurals, options){
            [id:id, text:text]
	}
        def getRootName(plurals, options) {
            return plurals?"comments":"comment"
        }
	def mapDependencies(plurals, options){
            return [:]
        }
}
