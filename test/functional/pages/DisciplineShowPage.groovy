package pages

import geb.Page

class DisciplineShowPage extends Page {

	static url = "/discipline/show"
	def titulo = "Show Discipline"
	
	static at = {
		title ==~ titulo
	}
	def existeNome(String disciplina){
		def html = $('html').getAttribute("innerHTML")
		assert html.contains(disciplina)
			  
	}

}