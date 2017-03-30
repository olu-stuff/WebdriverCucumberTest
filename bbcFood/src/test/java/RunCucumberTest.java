


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
public class RunCucumberTest {
	//maven doesnt know how to run cucumber test unless you specify the following :
	//put the word Test at the end of the test class RunCucumberTest
	//keep this test class in the scr/test/java path
	
	//you could always just put the feature file in a folder called test and maven will pick this up too
	
}
