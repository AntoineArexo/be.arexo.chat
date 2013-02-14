package be.arexo.chat

class Comment {
    
    String text
    
    static belongsTo = [post:Post]

    static constraints = {
    }
}
