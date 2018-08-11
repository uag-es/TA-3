package pages

import java.util.Date;

import geb.Page

class DisciplineCreatePage extends Page {

	static url = "discipline/create"
	def titulo = "Create Discipline"
	
	static at = {
		title ==~ titulo
	}
	
	def createDiscipline(String nomeDisciplina, String dataInicioAula, String professor){
		$("form").discipline = nomeDisciplina
		$("select", name:"applicationDate").click()
		$("select", name:"applicationDate").value(dataInicioAula)
		$("form").professor = professor
	
	}
	
	def submit(){
		$("input", name: "create").click()
	}
	
}