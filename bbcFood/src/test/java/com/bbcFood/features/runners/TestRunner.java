package com.bbcFood.features.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@RunOnly",
        features = "src/test/java/com/bbcFood/features",
        glue = "com/bbcFood/features/steps",
        plugin = {"pretty", "html:src/test/java/com/reports", "junit:src/test/java/com/reports/junit_report.xml"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        strict = true
        )
public class TestRunner {
	
	
}
