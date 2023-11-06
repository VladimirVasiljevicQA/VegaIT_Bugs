package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"html:target/cucmber_html_report.html","pretty"},
features="src/test/java/features",
glue={"stepDefinitions"},
tags="@all"
		
)
public class Runner extends AbstractTestNGCucumberTests{

}
