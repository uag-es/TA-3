package steps

import static cucumber.api.groovy.EN.*
import ta.Discipline


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
