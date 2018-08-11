Feature: Cadastrar disciplina
  As a administrador do sistema 
  I want to cadastrar disciplina
  so that ele seja cadastrado
  
  
  Scenario:Cadastrar disciplina corretamente(controller)
  	Given nao existe uma disciplina armazenado no sistema com nome "matematica" e professor "joao"
  	When cadastro uma disciplina no sistema com nome "matematica",professor "joao" e data de inicio das aulas "10/08/2018"
  	Then existe apenas uma disciplina armazenada no sistema com o nome "matematica" e professor "joao"
  
  	
  Scenario:Cadastrar disciplina corretamente
  	Given eu estou na pagina de cadastrar disciplina
  	When preencho os campos com nome da disciplina "matematica",a data do inicio das aulas "10/08/2018" e o nome do professor "joao"
  	And pressiono o botao criar
  	Then eu vejo os detalhes da disciplina "matematica" 
  	