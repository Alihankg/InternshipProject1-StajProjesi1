package stepDefs;

import io.cucumber.java.en.When;
import pages.ContentPage;

public class US_009 {
    ContentPage contentPage = new ContentPage();
    @When("I add Bank Account in Bank Accounts")
    public void iAddBankAccountInBankAccounts() {
        contentPage.add();
        contentPage.fillDialogField("Name", "Alihan Name");
        contentPage.fillDialogField("IBAN", "Alihan IBAN");
        contentPage.select("Currency", "KGS");
        contentPage.fillDialogField("Integration Code", "Alihan Integration Code");
        contentPage.saveAndConfirm();
    }

    @When("I update Bank Account in Bank Accounts")
    public void iUpdateBankAccountInBankAccounts() {
        contentPage.edit();
        contentPage.fillDialogField("Name", "Updating Alihan Name");
        contentPage.saveAndConfirm();
    }

    @When("I delete Bank Account in Bank Accounts")
    public void iDeleteBankAccountInBankAccounts() {
        contentPage.deleteAndConfirm();
    }
}
