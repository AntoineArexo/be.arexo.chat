package be.arexo.chat

import grails.converters.JSON
class CommentController {

    def show() {
        if (params.id && Comment.exists(params.id)) {
            def c = Comment.findById(params.id)
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
