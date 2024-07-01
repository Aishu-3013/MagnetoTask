package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.Reports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\magneto.feature", glue = "org.stepdefinition", dryRun = false, plugin = {
		"json:target\\Reports\\magnetojsonreport.json", "html:target\\Reports\\magnetohtmlreport",
		"junit:target\\Reports\\magnetojunitreport.xml" }, publish = true)
public class TestRunner {
	@AfterClass
	public static void reportName() {
		Reports.toGenerateReport("target\\Reports\\magnetojsonreport.json");
	}
}
