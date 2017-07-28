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
		if (name.equals("relatorio de teste de report")){
			boolean b = true
		}
		boolean compatible = false
		if(report.getName().equals(name) && report.getTipo().equals(tipo) && report.getValor() == valor && report.getAvaliacao().equals(avaliacao)) compatible = true;
		String no = report.getName()
		String ti = report.getTipo()
		double va = report.getValor()
		String aval = report.getAvaliacao()
		boolean n = report.getName().equals(name)
		boolean t = report.getTipo().equals(tipo)
		boolean v = report.getValor().equals(valor)
		boolean a = report.getAvaliacao().equals(avaliacao)
		n = no.equals(name)
		t = ti.equals(tipo)
		v = va.equals(valor)
		a = aval.equals(avaliacao)
		return compatible
	}
	
}