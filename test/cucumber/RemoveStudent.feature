Feature: Remove Student
  As a professor
  I want to remove students in the system
  So I can delete all the informations about him

#GUI Scenario - Gabrielle Amorim
@ignore
	Scenario: Delete an existing student 
	  Given I am in the "Student Listagem" page
	  And I can see the name of "Gabrielle Amorim" with login "ga" in the list of students
	  #And I see the student "Gabrielle Amorim" with login "ga" on the "Student Listagem" page
	  When I remove "Gabrielle Amorim" with login "ga"
	  Then "Gabrielle Amorim" with login "ga" is no longer on the "Student Listagem" page
	  
	  