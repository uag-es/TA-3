package pages.ReportsPages

import geb.Page

/**
 * Created by Milena Carneiro on 07/05/2016.
 */
class ShowReportsPage extends Page {
    static url = "/TA/report/show"
    static at = {
        title ==~/Show Report/
    }
	def boolean checkName(String name) {
		if ($("tbody").has("a", name: name)) return false
		return true
	}
	def boolean checkType(String tipo) {
		if ($("tbody").has("a", name: tipo)) return false
		return true
	}

	def boolean checkAvaliacao(String avaliacao) {
		if ($("tbody").has("a", name: avaliacao)) return false
		return true
	}
}
