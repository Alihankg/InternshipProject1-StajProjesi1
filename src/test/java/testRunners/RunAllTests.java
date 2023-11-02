package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/US_000.feature"},
        glue={"stepDefs"},
        plugin = {"pretty",
            "html:target/cucumber"
        }
)
public class RunAllTests extends AbstractTestNGCucumberTests {
}