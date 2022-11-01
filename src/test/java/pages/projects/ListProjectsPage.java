package pages.projects;

import baseEntities.BasePage;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListProjectsPage extends BasePage {
    private final By pageHeaderTitleLocator = By.className("page_title");
    private final By listOfProjectsTableLocator = By.className("grid");

    public ListProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return pageHeaderTitleLocator;
    }

    public WebElement getPageHeaderTitle() {
        return waitsService.waitForVisibilityBy(pageHeaderTitleLocator);
    }

    public Table getListOfProjects() {
        return new Table(driver, waitsService.waitForVisibilityBy(listOfProjectsTableLocator)) ;
    }
}
