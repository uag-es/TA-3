import ta.ReportController
import ta.Discipline

class BootStrap {

    def init = {servletContext ->
	
		def dataAula1 = new Date()
		def mat = new Discipline(
				discipline: "matematica",
				classTime: dataAula1,
				professor: "joao"
			)
	    mat.save(failOnError: true)   
    
		def dataAula2 = new Date()
		def ing = new Discipline(
				classTime: dataAula1,
				discipline: "ingles",
				professor: "ana"
			)
		ing.save(failOnError: true)
		
		def dataAula3 = new Date()
		def port = new Discipline(
				discipline: "portugues",
				classTime: dataAula1,
				professor: "maria"
			)
		port.save(failOnError: true)
		
		def dataAula4 = new Date()
		def fis = new Discipline(
				discipline: "fisica",
				classTime: dataAula1,
				professor: "joao"
			)
		fis.save(failOnError: true)
		
		}
		
	def destroy = {
    }
}
