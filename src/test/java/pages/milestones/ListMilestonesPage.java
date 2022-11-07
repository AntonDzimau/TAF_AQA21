package pages.milestones;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListMilestonesPage extends BasePage {
    private final static String pagePath = "index.php?/milestones/overview/37";
    private final By pageHeaderTitleLocator = By.className("page_title");
    private final By listOfMilestonesTableLocator = By.className("grid");

    public ListMilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return pageHeaderTitleLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getPageHeaderTitle() {
        return waitsService.waitForVisibilityBy(pageHeaderTitleLocator);
    }

    public Table getListOfMilestones() {
        return new Table(driver, waitsService.waitForVisibilityBy(listOfMilestonesTableLocator));
    }
}
