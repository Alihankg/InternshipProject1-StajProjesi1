package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin = {"pretty",
            "html:target/cucumber"
        }
)
public class AllTests extends AbstractTestNGCucumberTests {
}