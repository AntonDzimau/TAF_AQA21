package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{
    private final static String pagePath = "index.php?/dashboard";
    private final By headerLogoLocator = By.xpath("//div[contains(text(),'TestRail QA')]");
    public TopMenuPage topMenuPage;

    public DashboardPage(WebDriver driver) {
        super(driver);
        topMenuPage = new TopMenuPage(driver);
    }


    @Override
    protected By getPageIdentifier() {
        return headerLogoLocator;
    }

    public void openPageByUrl() {
       super.openPageByUrl(pagePath);
    }

    public WebElement getHeaderLogo() {
       return waitsService.waitForVisibilityBy(headerLogoLocator);
    }

}
