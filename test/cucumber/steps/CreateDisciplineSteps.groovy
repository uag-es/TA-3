package steps

import static cucumber.api.groovy.EN.*
import ta.Discipline
import pages.DisciplineCreatePage
import pages.DisciplineShowPage

Given(~/^nao existe uma disciplina armazenado no sistema com nome "(.*?)" e professor "(.*?)"$/) { String disciplina, String professor ->
	def discipline = Discipline.findAllByDisciplineAndProfessor(disciplina, professor)
	assert discipline.size() == 0
}

When(~/^cadastro uma disciplina no sistema com nome "(.*?)",professor "(.*?)" e data de inicio das aulas "(.*?)"$/) { String disciplina, String professor, String dataInicioAula ->
	DisciplineTestDataAndOperations.createDiscipline(disciplina,professor,dataInicioAula)
		
}

Then(~/^existe apenas uma disciplina armazenada no sistema com o nome "(.*?)" e professor "(.*?)"$/) { String disciplina, String professor ->
	def discipline = Discipline.findAllByDisciplineAndProfessor(disciplina, professor)
	assert discipline.size() == 1
}

Given(~/^eu estou na pagina de cadastrar disciplina$/) { ->
	to DisciplineCreatePage
	at DisciplineCreatePage
}

When(~/^preencho os campos com nome da disciplina "(.*?)",a data do inicio das aulas "(.*?)" e o nome do professor "(.*?)"$/) { String disciplina, String dataInicioAula, String professor ->
	page.createDiscipline(disciplina, dataInicioAula, professor)
}

When(~/^pressiono o botao criar$/) { ->
	page.submit()
}

Then(~/^eu vejo os detalhes da disciplina "(.*?)"$/) { String disciplina ->
	at DisciplineShowPage
	page.existeNome(disciplina)
}