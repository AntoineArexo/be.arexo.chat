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
        if (params.id && Comment.exists(params.id)) {
            def c = Comment.findById(params.id)
            c.properties = params
            c.save()
            render c as JSON
        }
    }
    def delete() {
        if (params.id && Comment.exists(params.id)) {
            def c = Comment.findById(params.id)
            c.delete()
        }
    }
    def save() {
        def c = new Comment(params)
        if (c.save()) {
            render c as JSON
        }
        else {
            render c.errors as JSON
        }
    }
}
