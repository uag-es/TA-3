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

	def GroupByProfessor(){
		def listaGeral = Discipline.list(params)
		def listaAgrupada = [:]
		listaGeral.each{
			if(listaAgrupada.containsKey(it.professor)){
				listaAgrupada[it.professor]['disciplina'] += it.discipline
				listaAgrupada[it.professor]['disciplineCount'] += 1		
			}
			else{
			listaAgrupada[it.professor] = ['professor':it.professor, 'disciplineCount':1]
			}
		}
		[disciplineInstanceList: listaAgrupada.values(), disciplineInstanceTotal: listaAgrupada.size()]
	}

    def show(Discipline disciplineInstance) {
        respond disciplineInstance
    }

    def create() {
        respond new Discipline(params)
    }
	
	def saveDiscipline(){
		def discipline = new Discipline(params)
		save(discipline)		
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
                this.flashAndRedirect('default.created.message', disciplineInstance.id, disciplineInstance)
            }
            '*' { respond disciplineInstance, [status: CREATED] }
        }
    }
	
	def flashAndRedirect(String codigo, int id, Discipline disciplineInstance){
		flash.message = message(code: codigo, args:[message(code: 'discipline.label', default: 'Discipline'),id])
		redirect disciplineInstance
		
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
                this.flashAndRedirect('default.updated.message', disciplineInstance.id, disciplineInstance)
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
