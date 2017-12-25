Feature: Update Student
  As a professor
  I want to update a student's information in the system
  So I can do it in a practical way
  
 #Controller Scenario - Gabrielle Amorim
	Scenario: Update a student login
      Given the student "Gabrielle Amorim" with login "ga" is registered in the system
	  When I update "ga" login for "gabi"
	  And "Gabrielle Amorim" with login "gabi" is not registered in the system
	  Then the student "Gabrielle Amorim" has her login updated for "gabi"