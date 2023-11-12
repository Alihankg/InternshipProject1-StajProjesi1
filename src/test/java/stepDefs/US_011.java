package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_011 {
    ContentPage contentPage = new ContentPage();
    @When("I add Discount in Discounts")
    public void iAddDiscountInDiscounts() {
        contentPage.add();
        contentPage.fillDialogInput("Description", "Alihan Description");
        contentPage.fillDialogInput("Priority", "1");
        contentPage.fillDialogInput("Integration Code", "Alihan Integration Code");
        contentPage.saveAndConfirm();
    }

    @When("I update Discount in Discounts")
    public void iUpdateDiscountInDiscounts() {
        contentPage.edit();
        contentPage.fillDialogInput("Description", "Updated Alihan Description");
        contentPage.saveAndConfirm();
    }

    @When("I delete Discount in Discounts")
    public void iDeleteDiscountInDiscounts() {
        contentPage.deleteAndConfirm();
    }
}
