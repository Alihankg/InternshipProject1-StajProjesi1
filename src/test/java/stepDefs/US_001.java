package stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContentPage;
import pages.NavbarPage;
public class US_001 {

    NavbarPage navbarPage = new NavbarPage();
    ContentPage contentPage = new ContentPage();

    @And("I've navigated to {string}")
    public void iVeNavigatedToPage(String page) {
        navbarPage.navigateToPage(page);
    }

    @When("I add Position Category in Position Categories")
    public void iAddPositionCategoryInPositionCategories(){
        contentPage.add();
        contentPage.fillDialogInput("Name", "Position Category");
        contentPage.saveAndConfirm();
    }

    @When("I update Position Category in Position Categories")
    public void iUpdatePositionCategoryInPositionCategories() {
        contentPage.edit();
        contentPage.fillDialogInput("Name", "Position Category 2");
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
