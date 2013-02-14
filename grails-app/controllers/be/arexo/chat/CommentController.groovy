package be.arexo.chat

import grails.converters.JSON
class CommentController {

    def show() {
        if (param.id && Comment.exists(param.id)) {
            def c = Comment.findById(param.id)
            render c as JSON
        }
        else {
            def all = Comment.list()
            render all as JSON
        }
    }
    def update() {
        
    }
    def delete() {
        
    }
    def save() {
        
    }
}
