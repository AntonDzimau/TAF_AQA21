package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivitySummaryPage extends BasePage {
    private final By reportTitleLocator = By.cssSelector("div.report-box-title");

    public ActivitySummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return reportTitleLocator;
    }


    public WebElement getReportTitle() {
        return waitsService.waitForVisibilityBy(reportTitleLocator);
    }

}
