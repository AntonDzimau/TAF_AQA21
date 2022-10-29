package pages;

import baseEntities.BasePage;
import elements.DropDown;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {
    private final static String pagePath = "index.php?/suites/view/1&group_by=cases:section_id&group_order=asc&display_deleted_cases=0";
    private final By reportDropDownLocator = By.cssSelector("a[href='#reportDropdown']");
    private final By activitySummaryLocator = By.xpath("//a[contains(.,'Activity Summary')]");
    private final By coverageForReferencesLocator = By.xpath("//a[contains(.,'Coverage for References')]");
    private final By propertyDistributionLocator = By.xpath("//a[contains(.,'Property Distribution')]");
    private final By statusTopsLocator = By.xpath("//a[contains(.,'Status Tops')]");


    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return reportDropDownLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public DropDown getReportDropDown() {
        return new DropDown(driver, waitsService.waitForVisibilityBy(reportDropDownLocator));
    }

    public Link activitySummary() {
        return new Link(driver, waitsService.waitForVisibilityBy(activitySummaryLocator));
    }

    public Link coverageForReferences() {
        return new Link(driver, waitsService.waitForVisibilityBy(coverageForReferencesLocator));
    }

    public Link propertyDistribution() {
        return new Link(driver, waitsService.waitForVisibilityBy(propertyDistributionLocator));
    }

    public Link statusTops() {
        return new Link(driver, waitsService.waitForVisibilityBy(statusTopsLocator));
    }

}
