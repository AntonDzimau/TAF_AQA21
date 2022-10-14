package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuBurgerPage extends BasePage {
    private final By logoutLinkLocator = By.linkText("Logout".toUpperCase());
    private final By allItemsLinkLocator = By.linkText("All Items".toUpperCase());
    private final By openBurgerMenuButtonLocator = By.id("react-burger-menu-btn");

    public TopMenuBurgerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return openBurgerMenuButtonLocator;
    }


    public WebElement getOpenBurgerMenuButton() {
        return driver.findElement(openBurgerMenuButtonLocator);
    }

    public WebElement getLogoutLink() {
        return driver.findElement(logoutLinkLocator);
    }

    public WebElement getAllItemsLink() {
        return driver.findElement(allItemsLinkLocator);
    }

    public void openBurgerMenu() {
        getOpenBurgerMenuButton().click();
    }

}
