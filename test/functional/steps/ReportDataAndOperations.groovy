package steps

import ta.Report
import ta.ReportController


class ReportDataAndOperations {

	public static void createReport(String name, String tipo, double valor, String avaliacao) {
		def controller = new ReportController()
		controller.params << [name: name, tipo: tipo, valor: valor, avaliacao: avaliacao]
		controller.save()
		controller.response.reset()
	}
	
	static public boolean compatibleTo(Report report, String name, String tipo, double valor, String avaliacao ){
		if(report.getName().equals(name) && report.getTipo().equals(tipo) && report.getValor() == valor && report.getAvaliacao().equals(avaliacao)) return true;
		else return false
	}
	
}