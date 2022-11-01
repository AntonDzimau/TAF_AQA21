package pages.testCases;

import baseEntities.BasePage;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCaseDetailsPage extends BasePage {
    private final By pageHeaderTitleLocator = By.className("page_title");
    private final By informationTableLocator = By.cssSelector("table.io");


    public TestCaseDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return pageHeaderTitleLocator;
    }

    public WebElement getPageHeaderTitle() {
        return waitsService.waitForVisibilityBy(pageHeaderTitleLocator);
    }

    public Table informationTable() {
        return new Table(driver, waitsService.waitForVisibilityBy(informationTableLocator));
    }
}
