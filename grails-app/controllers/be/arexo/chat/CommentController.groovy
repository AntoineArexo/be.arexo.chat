package be.arexo.chat

import grails.converters.JSON
import com.appstart.Mapper

class CommentController {

    def show() {
        def id = params.id
        if (id && Comment.exists(id)) {
            def c = Comment.get(id)
            render Mapper.getMap(c, [:]) as JSON
        }
        else {
            def all = Comment.list()
            render Mapper.getMap(all, [:]) as JSON
        }
    }
    def update() {
        def id = params.id
        if (id && Comment.exists(id)) {
            def c = Comment.get(id)
            c.properties = params
            if (c.save()) {
                render Mapper.getMap(c, [:]) as JSON
            }
        }
    }
    def delete() {
        def id = params.id
        if (id && Comment.exists(id)) {
            def c = Comment.findById(id)
            c.delete(flush:true)
            render [] as JSON
        }
    }
    def save() {
        def c = new Comment(params)
        if (!c.validate()) {
            responce.status = 422
            return render(c.errors as JSON)
        }
        if (c.save()) {
            render Mapper.getMap(c, [:]) as JSON
        }
        else {
            render c.errors as JSON
        }
    }
}
