package steps

import cucumber.api.PendingException
import pages.AddGroupStudentPage
import ta.Student
import steps.AddStudentsTestDataAndOperations
import pages.AddStudentsPage
import pages.StudentPages.StudentPage
import ta.StudentController
import steps.RemoveStudentsTestDataAndOperations
import steps.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

int countStudent

Given(~/^I can see the name of "(.*?)" with login "(.*?)" in the list of students$/) { String name, String login ->
	to StudentPage
	assert page.confirmStudent(name, login) == false
}

When(~/^I remove "(.*?)" with login "(.*?)"$/) { String name, String login ->
	Student student = new Student(name, login)
	AddStudentsTestDataAndOperations.deleteStudent(student)
	assert Student.findByLogin(login) == null
}

Then(~/^"(.*?)" with login "(.*?)" is no longer on the "(.*?)" page$/) { String name, String login, String page ->
	to StudentPage
	at StudentPage
	assert Student.findByLogin(login) == null
}

