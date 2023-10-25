package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue={"stepDefs"},
        plugin = {"pretty",
            "html:target/cucumber"
        }
)
public class AllTests extends AbstractTestNGCucumberTests {
}