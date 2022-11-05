package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuBurgerPage extends BasePage {
    @FindBy(linkText = "LOGOUT")
    public WebElement logoutLink;
    @FindBy(linkText = "ALL ITEMS")
    public WebElement allItemsLink;
    @FindBy(id = "react-burger-cross-btn")
    public WebElement closeBurgerMenuButton;

    public TopMenuBurgerPage(WebDriver driver) {
        super(driver);
    }

    public void closeBurgerMenu() {
        closeBurgerMenuButton.click();
    }

}
