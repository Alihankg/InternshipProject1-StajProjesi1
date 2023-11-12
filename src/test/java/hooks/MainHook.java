package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import managers.DriverManager;

public class MainHook {

    @Before
    public void before(){
        DriverManager.getDefaultDriver();
    }

    @After
    public void after(){
        DriverManager.clearCookies();
    }

    @AfterAll
    public static void before_or_after_all(){
        DriverManager.quitDriver();
    }
}
