package stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pages.ContentPage;
import pages.NavbarPage;
public class US_001 {

    NavbarPage navbarPage;
    ContentPage contentPage;

    public US_001() {
        final PageObjectManager pom = new PageObjectManager();
        navbarPage = pom.getNavbarPage();
        contentPage = pom.getContentPage();
    }

    @And("I've navigated to Position Categories")
    public void iVeNavigatedToPositionCategories() {
        navbarPage.navigateToPage("Position Categories");
    }

    @When("I add Position Category in Position Categories")
    public void iAddPositionCategoryInPositionCategories(){
        contentPage.add();
        contentPage.fillInput("Name", "Position Category");
        contentPage.saveAndConfirm();
    }

    @When("I update Position Category in Position Categories")
    public void iUpdatePositionCategoryInPositionCategories() {
        contentPage.edit();
        contentPage.fillInput("Name", "Position Category 2");
        contentPage.saveAndConfirm();
    }

    @When("I delete Position Category in Position Categories")
    public void iDeletePositionCategoryInPositionCategories() {
        contentPage.deleteAndConfirm();
    }

    @Then("I should see {string} message")
    public void iShouldSeeASuccessMessage(String message){
        contentPage.assertMessageDisplayedAndClose(message);
    }

}
