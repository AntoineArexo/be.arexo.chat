package be.arexo.chat

import grails.converters.JSON
import com.appstart.Mapper

class CommentController {

    def show() {
        if (params.id && Comment.exists(params.id)) {
            def c = Comment.findById(params.id)
            render Mapper.getMap(c, [:]) as JSON
        }
        else {
            def all = Comment.list()
            render Mapper.getMap(all, [:]) as JSON
        }
    }
    def update() {
        if (params.id && Comment.exists(params.id)) {
            def c = Comment.findById(params.id)
            c.properties = params
            c.save()
            render Mapper.getMap(c, [:]) as JSON
        }
    }
    def delete() {
        if (params.id && Comment.exists(params.id)) {
            def c = Comment.findById(params.id)
            c.delete()
            render [] as JSON
        }
    }
    def save() {
        def c = new Comment(params)
        if (c.save()) {
            render Mapper.getMap(c, [:]) as JSON
        }
        else {
            render c.errors as JSON
        }
    }
}
