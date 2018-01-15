package ta

class Discipline {
	
	String discipline
	Date classTime
	String professor
	static hasMany = [students : Student]
	
    static constraints = {
		discipline blank: false
		classTime blank: false
		professor blank: false
    }
}
