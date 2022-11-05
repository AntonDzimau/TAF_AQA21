package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    private final static String pagePath = "cart.html";
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;
    @FindBy(id = "checkout")
    public WebElement checkoutButton;
    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartItemsName;
    @FindBy(className = "title")
    public WebElement cartLabel;
    @FindBy(id = ".btn_secondary.btn_small")
    public List<WebElement> removeFromCartButtons;

    public HeaderPage headerPage;

    public CartPage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
