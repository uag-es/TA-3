package steps

import ta.Student
import ta.StudentController

static public void deleteStudent(Student studentInstance){
	def cont = new StudentController()
	cont.params << [name: studentInstance.name, login: studentInstance.login]
	cont.delete(studentInstance)
	cont.response.reset()
}