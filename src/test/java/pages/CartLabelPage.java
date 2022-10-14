package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartLabelPage extends BasePage {
    private final By shoppingCartBadgeLocator = By.className("shopping_cart_badge");
    private final By cartButtonLocator = By.className("shopping_cart_link");

    public CartLabelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return cartButtonLocator;
    }


    public WebElement getShoppingCartBadge() {
        return driver.findElement(shoppingCartBadgeLocator);
    }

    public WebElement getCartButton() {
        return driver.findElement(cartButtonLocator);
    }

    public void clickCartButton() {
        getCartButton().click();
    }
}
