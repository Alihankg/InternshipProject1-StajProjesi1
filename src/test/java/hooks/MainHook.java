package hooks;

import helpers.cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;

public class MainHook {

    TestContext testContext;
    public MainHook() {
    }

    @Before
    public void before(){
        DriverManager.getDefaultDriver();
    }

    @After
    public void after(Scenario scenario){
        DriverManager.quitDriver();
    }
}
