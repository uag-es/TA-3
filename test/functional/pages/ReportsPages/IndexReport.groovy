package pages.ReportsPages

import geb.Page
/**
 * Created by Milena Carneiro on 25/06/2016.
 */
class IndexReport extends Page {
    static url = "/TA/report/index"
    static at={
        title ==~/Report List/
    }
	
	boolean confirmReport(String name, String tipo, double valor, String avaliacao) {
		boolean r = false
		boolean findName = $("tr").find("td").has("a",text: name)
		boolean findTipo = $ ("tr").has("td",text: tipo)
		boolean findAvaliacao = $ ("tr").has("td",text: avaliacao)
		if(findName && findTipo && valor >= 0.0 && findAvaliacao){
			r = true
		}
		return r
	}

    def selectReport(String name){
        $("td").find("a", name: name).click()
    }
	
}
