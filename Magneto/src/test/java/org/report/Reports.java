package org.report;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reports {

	public static void toGenerateReport(String json) {
		File file = new File("target\\Reports");
		Configuration config = new Configuration(file, "Magneto WebPage");
		config.addClassifications("Website", "Magneto");
		config.addClassifications("Environment", "Qa");
		config.addClassifications("Author", "Aishwarya ");
		config.addClassifications("os", "Windows");
		config.addClassifications("IDE", "eclipse");
		List<String> lis = new LinkedList<>();
		lis.add(json);
		ReportBuilder r = new ReportBuilder(lis, config);
		r.generateReports();
	}
}
