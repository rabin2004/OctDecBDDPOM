package runnerPkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Junit

@RunWith(Cucumber.class)
@CucumberOptions(	features="C:\\Users\\User\\eclipse-workspace\\OctDecCucumber\\src\\test\\java\\feature",
					glue="stepDefinition",
					plugin= {"pretty", "html:target/cucumberReport.html", "json:target/jsonReport.json"},
					monochrome = true,
//					tags = "@DataDriven" // -> single tag
//					tags = "@DataDriven or @Smoke" // -> either or tag
//					tags = "@Release1.0 and @SearchFunctionality" // -> both matching scenario/feature
//					tags = "~@Smoke" // -> exclude Smoke tag
					tags = "@Smoke and not @DataDriven" // Smoke but not DataDriven
		)

public class RunnerClass {

}
