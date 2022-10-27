package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CataloguePage extends BasePage {
    private final static String pagePath = "inventory.html";
    private final By sortContainerLocator = By.className("product_sort_container");
    private final By firstItemByNameLocator = By.xpath("//*[@class='inventory_item'][1]//a/div");
    private final By firstItemByPriceLocator = By.xpath("//*[@class='inventory_item'][1]//button//preceding-sibling::div");
    private By addToCartButtonLocator = By.className("btn_primary");
    private By removeFromCartButtonLocator = By.className("btn_secondary");

    public TopMenuBurgerPage topMenuBurgerPage;
    public CartLabelPage cartLabelPage;

    public CataloguePage(WebDriver driver) {
        super(driver);
        topMenuBurgerPage = new TopMenuBurgerPage(driver);
        cartLabelPage = new CartLabelPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return sortContainerLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


    public WebElement getSortContainer() {
        return driver.findElement(sortContainerLocator);
    }

    public WebElement getFirstItemByName() {
        return driver.findElement(firstItemByNameLocator);
    }

    public WebElement getFirstItemByPrice() {
        return driver.findElement(firstItemByPriceLocator);
    }

    public List<WebElement> getAddToCartButton() {
        return driver.findElements(addToCartButtonLocator);
    }

    public List<WebElement> getRemoveFromCartButton() {
        return driver.findElements(removeFromCartButtonLocator);
    }

    public WebElement getAddToCartButton(String value) {
        addToCartButtonLocator = By.id(value);
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getRemoveFromCartButton(String value) {
        removeFromCartButtonLocator = By.id(value);
        return driver.findElement(removeFromCartButtonLocator);
    }

    public Select selectMenu() {
        return new Select(getSortContainer());
    }
}
