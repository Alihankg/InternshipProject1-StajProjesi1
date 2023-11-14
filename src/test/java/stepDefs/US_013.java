package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContentPage;
import pages.NavbarPage;

import java.util.HashMap;
import java.util.Map;

public class US_013 {

    ContentPage contentPage = new ContentPage();
    NavbarPage navbarPage = new NavbarPage();

    // In the future, we might need to change the return type to a LinkedHashMap because there may be some dependencies
    private Map<String, String> parseFieldsTable(String fieldsTable){
        Map<String, String> fieldValues = new HashMap<>();

        String[] pairs = fieldsTable.split(",\\s*");

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String field = keyValue[0].trim();
                String value = keyValue[1].trim();
                fieldValues.put(field, value);
            }
        }

        return fieldValues;
    }

    private void fillFieldsAndSave(String fieldsTable){
        Map<String, String> fieldValues = parseFieldsTable(fieldsTable);
        contentPage.waitUntilDialogDisplayed();
        for(Map.Entry<String, String> kv : fieldValues.entrySet()){
            contentPage.fillDialogField(kv.getKey(), kv.getValue());
        }
        contentPage.saveAndConfirm();
    }

    @Given("I've navigated to {}")
    public void iVeNavigatedTo(String page) {
        navbarPage.navigateToPage(page);
    }

    @When("I add a new item with following credentials:")
    public void iAddANewItemWithFollowingCredentials(String fieldsTable) {
        contentPage.sort();contentPage.sort(); // sort to get the new added element on top
        contentPage.add();
        fillFieldsAndSave(fieldsTable);
    }

    @When("I update the item with following credentials:")
    public void iUpdateTheItemWithFollowingCredentials(String fieldsTable) {
        contentPage.edit();
        fillFieldsAndSave(fieldsTable);
    }

    @When("I delete the item")
    public void iDeleteTheItem() {
        contentPage.deleteAndConfirm();
    }

    @Then("the result message should contain {string}")
    public void thereShouldBeSuccessfullyMessage(String message) {
        contentPage.assertMessageContainsAndClose(message);
    }
}
