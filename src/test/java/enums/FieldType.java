package enums;

public enum FieldType {
    INPUT("//ms-dialog-content//input[@data-placeholder='%s']"),
    SELECT("//ms-dialog-content//span[text()='%s']/ancestor::*/preceding-sibling::mat-select"),
    CHECKBOX("//ms-dialog-content//span[text()='%s']/ancestor::mat-select"),
    TEXTAREA("//ms-dialog-content//mat-label[text()='%s']/ancestor::span/preceding-sibling::*");

    public final String xpath;

    FieldType(String xpath) {
        this.xpath = xpath;
    }
}
