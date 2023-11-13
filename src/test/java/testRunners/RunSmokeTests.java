package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/resources/features"},
        glue={"stepDefs"}
)
public class RunSmokeTests extends AbstractTestNGCucumberTests {
}