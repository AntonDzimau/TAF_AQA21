package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CataloguePage extends BasePage {
    private final static String pagePath = "inventory.html";
    @FindBy(className = "product_sort_container")
    public WebElement sortContainer;
    @FindBy(xpath = "//*[@class='inventory_item'][1]//a/div")
    public WebElement firstItemByName;
    @FindBy(xpath = "//*[@class='inventory_item'][1]//button//preceding-sibling::div")
    public WebElement firstItemByPrice;
    @FindBy(className = "btn_primary")
    public List<WebElement> addToCartButtons;
    @FindBy(className = "btn_secondary")
    public List<WebElement> removeFromCartButtons;

    public HeaderPage headerPage;

    public CataloguePage(WebDriver driver) {
        super(driver);
        headerPage = new HeaderPage(driver);
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public Select selectMenu() {
        return new Select(sortContainer);
    }
}
