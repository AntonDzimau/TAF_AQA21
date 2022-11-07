package pages.milestones;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.Input;
import elements.Textarea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMilestonePage extends BasePage {
    private final static String pagePath = "index.php?/milestones/add/37";
    private final By nameInputLocator = By.id("name");
    private final By referenceInputLocator = By.id("reference");
    private final By descriptionTextareaLocator = By.id("description_display");
    private final By isCompletedCheckBoxLocator = By.id("is_completed");
    private final By acceptButtonLocator = By.xpath("//button[contains(.,'Add Milestone')]");
    private final By cancelButtonLocator = By.cssSelector(".milestone-form-cancel");

    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return acceptButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public Input getNameInput() {
        return new Input(driver, waitsService.waitForVisibilityBy(nameInputLocator));
    }

    public Input getReferenceInput() {
        return new Input(driver, waitsService.waitForVisibilityBy(referenceInputLocator));
    }

    public Textarea getDescriptionTextarea() {
        return new Textarea(driver, waitsService.waitForVisibilityBy(descriptionTextareaLocator));
    }

    public CheckBox getIsCompletedCheckBox() {
        return new CheckBox(driver, waitsService.waitForVisibilityBy(isCompletedCheckBoxLocator));
    }

    public Button getCancelButton() {
        return new Button(driver, waitsService.waitForVisibilityBy(cancelButtonLocator));
    }

    public Button getAcceptButton() {
        return new Button(driver, waitsService.waitForVisibilityBy(acceptButtonLocator));
    }
}
