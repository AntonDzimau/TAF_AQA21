package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HeaderPage extends BasePage {
    @FindBy(id = "react-burger-menu-btn")
    public WebElement openBurgerMenuButton;
    @FindBy (className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;
    @FindBy (className = "shopping_cart_link")
    public WebElement cartButton;


    public TopMenuBurgerPage topMenuBurgerPage;

    public HeaderPage(WebDriver driver) {
        super(driver);
        topMenuBurgerPage = new TopMenuBurgerPage(driver);
    }

    public void openBurgerMenu() {
        openBurgerMenuButton.click();
    }

    public void openCart() {
        cartButton.click();
    }

}
