package pages.testCases;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BaseTestCasePage {

    private final static String pagePath = "index.php?/cases/add/10";
    private final By acceptButtonLocator = By.xpath("//button[contains(.,'Add Test Case')]");
    private final By acceptAndNextButtonLocator = By.id("accept_and_next");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return acceptButtonLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public Button getAcceptButton() {
        return new Button(driver, waitsService.waitForVisibilityBy(acceptButtonLocator));
    }

    public Button getAcceptAndNextButton() {
        return new Button(driver, waitsService.waitForVisibilityBy(acceptAndNextButtonLocator));
    }
}
