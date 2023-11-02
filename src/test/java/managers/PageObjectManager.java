package managers;

import pages.DefaultPage;
import pages.LoginPage;
import pages.NavbarPage;

public class PageObjectManager {
    private static LoginPage loginPage;
    private static NavbarPage navbarPage;
    private static DefaultPage defaultPage;

    private PageObjectManager() {
    }

    public static LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public static NavbarPage getNavbarPage(){
        return (navbarPage == null) ? navbarPage = new NavbarPage() : navbarPage;
    }

    public static DefaultPage getDefaultPage(){
        return (defaultPage == null) ? defaultPage = new DefaultPage() : defaultPage;
    }
}
