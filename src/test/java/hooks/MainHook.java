package hooks;

import helpers.cucumber.TestContext;
import managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MainHook {

    TestContext testContext;

    public MainHook(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before(){

    }

    @After
    public void after(Scenario scenario){
        DriverManager.quitDriver();
    }
}
