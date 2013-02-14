package be.arexo.chat

class Post {
    
    String title
    String text
    
    static hasMany = [comments: Comment]

    static constraints = {
    }
}
