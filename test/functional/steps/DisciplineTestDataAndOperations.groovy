package steps

import ta.DisciplineController
import ta.Discipline
import java.text.SimpleDateFormat
import java.util.Date;
	
class DisciplineTestDataAndOperations{

	static public void createDiscipline(String disciplineName, String professorName, String classTime){
		def controller = new DisciplineController()
		def data = formattedDate(classTime)
		controller.params <<[discipline: disciplineName,
							 classTime:  data,
							 professor:  professorName]					 
		controller.create()
		controller.saveDiscipline()
		controller.response.reset()	
	}
	
	public static Date formattedDate(String dateInString){
		def formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date date = formatter.parse(dateInString);
		return date;
	}
		
}