package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@RegressionTest",
        features = {"src/test/java/features"},
        glue={"stepDefs"}
)
public class RegressionTests extends AbstractTestNGCucumberTests {
}