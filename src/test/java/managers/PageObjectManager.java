package managers;

import pages.ContentPage;
import pages.LoginPage;
import pages.NavbarPage;

public class PageObjectManager {
    private static LoginPage loginPage;
    private static NavbarPage navbarPage;
    private static ContentPage contentPage;

    public PageObjectManager() {
    }

    public LoginPage getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public NavbarPage getNavbarPage(){
        return (navbarPage == null) ? navbarPage = new NavbarPage() : navbarPage;
    }

    public ContentPage getContentPage(){
        return (contentPage == null) ? contentPage = new ContentPage() : contentPage;
    }
}
