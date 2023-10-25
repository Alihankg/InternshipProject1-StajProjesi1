package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/features"},
        glue={"stepDefs"}
)
public class SmokeTests extends AbstractTestNGCucumberTests {
}