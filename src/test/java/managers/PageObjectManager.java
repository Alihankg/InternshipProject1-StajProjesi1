package managers;

import pages.DefaultPage;
import pages.LoginPage;
import pages.NavbarPage;

public class PageObjectManager {
    private LoginPage loginPage;
    private NavbarPage navbarPage;
    private DefaultPage defaultPage;

    public PageObjectManager() {
    }

    public LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public NavbarPage getNavbarPage(){
        return (navbarPage == null) ? navbarPage = new NavbarPage() : navbarPage;
    }

    public DefaultPage getDefaultPage(){
        return (defaultPage == null) ? defaultPage = new DefaultPage() : defaultPage;
    }
}
