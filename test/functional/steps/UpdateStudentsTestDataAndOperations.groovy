package steps

import ta.StudentController
import ta.Student

class UpdateStudentsTestDataAndOperations{
	
	static public void updateStudent(String name, String login){
		def cont = new StudentController()
		cont.params << [name: name, login: login]
		cont.createAndSaveStudent()
		cont.response.reset()
	}
	
	static public void updateLogin(String login1, String login2){
		Student student = Student.findByLogin(login1)
		student.setLogin(login2)
	}
}

