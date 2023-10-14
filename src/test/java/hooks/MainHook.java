package hooks;

import drivers.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MainHook {

    @Before
    public void before(){}

    @After
    public void after(Scenario scenario){
        Driver.quitDriver();
    }
}
