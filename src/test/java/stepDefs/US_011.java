package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_011 {
    ContentPage contentPage = new ContentPage();
    @When("I add Discount in Discounts")
    public void iAddDiscountInDiscounts() {
        contentPage.add();
        contentPage.fillDialogField("Description", "Alihan Description");
        contentPage.fillDialogField("Integration Code", "Alihan Integration Code");
        contentPage.fillDialogField("Priority", "1");
    }

    @When("I update Discount in Discounts")
    public void iUpdateDiscountInDiscounts() {
    }

    @When("I delete Discount in Discounts")
    public void iDeleteDiscountInDiscounts() {
    }
}
