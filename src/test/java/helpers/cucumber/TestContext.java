package helpers.cucumber;

import managers.PageObjectManager;
public class TestContext {
    private final PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public TestContext(){
        pageObjectManager = new PageObjectManager();
        scenarioContext = new ScenarioContext();
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}