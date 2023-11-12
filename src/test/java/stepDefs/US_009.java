package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_009 {
    ContentPage contentPage = new ContentPage();
    @When("I add Bank Account in Bank Accounts")
    public void iAddBankAccountInBankAccounts() {
        contentPage.add();
        contentPage.fillDialogInput("Name", "Alihan Name");
        contentPage.fillDialogInput("IBAN", "Alihan IBAN");
        contentPage.select("Currency", "KGS");
        contentPage.fillDialogInput("Integration Code", "Alihan Integration Code");
        contentPage.saveAndConfirm();
    }

    @When("I update Bank Account in Bank Accounts")
    public void iUpdateBankAccountInBankAccounts() {
        contentPage.edit();
        contentPage.fillDialogInput("Name", "Updating Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Bank Account in Bank Accounts")
    public void iDeleteBankAccountInBankAccounts() {
        contentPage.deleteAndConfirm();
    }
}
