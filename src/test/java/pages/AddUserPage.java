package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.projects.BaseProjectPage;

public class AddUserPage extends BaseProjectPage {
    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

/*    private final By radioButtonLocator = By.xpath("//div[@class='row add-project-row']/..");
    private final static String pagePath = "index.php?/admin/projects/add";

    public AddUserPage(WebDriver driver) {
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
    }*/

}
