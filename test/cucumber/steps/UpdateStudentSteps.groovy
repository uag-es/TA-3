package steps

import cucumber.api.PendingException
import pages.AddGroupStudentPage
import ta.Student
import steps.AddStudentsTestDataAndOperations
import pages.AddStudentsPage
import pages.StudentPages.StudentPage
import ta.StudentController
import steps.*
import steps.UpdateStudentsTestDataAndOperations

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

int countStudent

When(~/^I update "(.*?)" login for "(.*?)"$/) { String login1, String login2 ->
	Student student = Student.findByLogin(login1)
	student.setLogin(login2)
	assert student.getLogin().equalsIgnoreCase(login2)
}

When(~/^"(.*?)" with login "(.*?)" is not registered in the system$/) { String name, String login ->
	Student student = Student.findByLogin(login)
	assert student == null
}

Then(~/^the student "(.*?)" has her login updated for "(.*?)"$/) { String name, String login ->
	Student student = Student.findByLogin(login)
	if(student != null){
		assert student.getName().equalsIgnoreCase(name)
	}
}