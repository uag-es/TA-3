package steps

import ta.Student
import ta.StudentController

/**
 * Created by rodrigocalegario on 5/28/16.
 */

class AddStudentsTestDataAndOperations {

    static public void createStudent(String name, String login){
        def cont = new StudentController()
        cont.params << [name: name, login: login]
        cont.createAndSaveStudent()
        cont.response.reset()
    }
	
	static public void deleteStudent(Student studentInstance){
		def cont = new StudentController()
		cont.params << [name: studentInstance.name, login: studentInstance.login]
		cont.delete(studentInstance)
		cont.response.reset()
	}
	
	static public void updateLogin(String login1, String login2){
		Student student = Student.findByLogin(login1)
		student.setLogin(login2)
	}
	

    static public boolean compatibleTo(Student student, String name, String login){
        
        if(student.getName().equals(name) && student.getLogin().equals(login)) return true;
        else return false
    }

    static public int countStudent(){
        return Student.list().size()
    }

    static public void createGroup(String group){
        def controller = new StudentController()
        controller.params << [name: group]
        controller.saveGroup()
    }

    static public int alunoQtd(String login){
        return Student.findAllByLogin(login).size()
    }


}
