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
	
	@Override
	public String toString(){
		return "Discipline: " + discipline + " - Class Time: " + classTime + " - Professor: " + professor
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Discipline){
			Discipline d = (Discipline) obj
			if(discipline.equals(d.getDiscipline())){
				return true
			}
		}
		return false
	}
}
