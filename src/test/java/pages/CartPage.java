package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";
    private final By continueShoppingButtonLocator = By.id("continue-shopping");
    private final By checkoutButtonLocator = By.id("checkout");
    private final By cartItemNameLocator = By.className("inventory_item_name");
    private final By cartLabelLocator = By.className("title");
    private By removeFromCartButtonLocator;

    public TopMenuBurgerPage topMenuBurgerPage;
    public CartLabelPage cartLabelPage;

    public CartPage(WebDriver driver) {
        super(driver);
        topMenuBurgerPage = new TopMenuBurgerPage(driver);
        cartLabelPage = new CartLabelPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return cartLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButtonLocator);
    }

    public WebElement getCheckoutButtonLocator() {
        return driver.findElement(checkoutButtonLocator);
    }

    public WebElement getCartItemName() {
        return driver.findElement(cartItemNameLocator);
    }

    public List<WebElement> getCartItemNames() {
        return driver.findElements(cartItemNameLocator);
    }

    public WebElement getRemoveFromCartButton(String value) {
        removeFromCartButtonLocator = By.id(value);
        return driver.findElement(removeFromCartButtonLocator);
    }
}
