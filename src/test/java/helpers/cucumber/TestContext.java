package helpers.cucumber;

import managers.PageObjectManager;
public class TestContext {
    private final PageObjectManager pageObjectManager;

    public TestContext(){
        pageObjectManager = new PageObjectManager();
    }
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}