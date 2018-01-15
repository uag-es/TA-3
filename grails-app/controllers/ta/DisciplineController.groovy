package ta



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DisciplineController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Discipline.list(params), model:[disciplineInstanceCount: Discipline.count()]
    }

    def show(Discipline disciplineInstance) {
        respond disciplineInstance
    }

    def create() {
        respond new Discipline(params)
    }

    @Transactional
    def save(Discipline disciplineInstance) {
        if (disciplineInstance == null) {
            notFound()
            return
        }

        if (disciplineInstance.hasErrors()) {
            respond disciplineInstance.errors, view:'create'
            return
        }

        disciplineInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'discipline.label', default: 'Discipline'), disciplineInstance.id])
                redirect disciplineInstance
            }
            '*' { respond disciplineInstance, [status: CREATED] }
        }
    }

    def edit(Discipline disciplineInstance) {
        respond disciplineInstance
    }

    @Transactional
    def update(Discipline disciplineInstance) {
        if (disciplineInstance == null) {
            notFound()
            return
        }

        if (disciplineInstance.hasErrors()) {
            respond disciplineInstance.errors, view:'edit'
            return
        }

        disciplineInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Discipline.label', default: 'Discipline'), disciplineInstance.id])
                redirect disciplineInstance
            }
            '*'{ respond disciplineInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Discipline disciplineInstance) {

        if (disciplineInstance == null) {
            notFound()
            return
        }

        disciplineInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Discipline.label', default: 'Discipline'), disciplineInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'discipline.label', default: 'Discipline'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
