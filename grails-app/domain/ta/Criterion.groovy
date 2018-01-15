package ta

class Criterion {
	String description
	String hab
	static constraints = {
		hab inList :["Raciocinio Logico", "Criatividade" ,"Interpretacao"], blank :false
		description unique: true, blank: false, nullable: false
	}

	public Criterion(String description, String hab){
		this.description = description
		this.hab = hab
		
	}
}
