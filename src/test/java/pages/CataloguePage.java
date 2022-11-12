package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.*;

public class CataloguePage {
    private final static String pagePath = "inventory.html";
    private final By sortContainerLocator = By.className("product_sort_container");
    private final By firstItemByNameLocator = By.xpath("//*[@class='inventory_item'][1]//a/div");
    private final By firstItemByPriceLocator = By.xpath("//*[@class='inventory_item'][1]//button//preceding-sibling::div");
    private final By addToCartButtonLocator = By.className("btn_primary");
    private final By removeFromCartButtonLocator = By.className("btn_secondary");

    public HeaderPage headerPage = new HeaderPage();

    public void openPageByUrl() {
        open(pagePath);
    }

    public SelenideElement getSortContainer() {
        return $(sortContainerLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getFirstItemByName() {
        return $(firstItemByNameLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getFirstItemByPrice() {
        return $(firstItemByPriceLocator).shouldBe(Condition.visible);
    }

    public ElementsCollection getAddToCartButtons() {
        return $$(addToCartButtonLocator)
                .shouldBe(CollectionCondition
                        .sizeGreaterThanOrEqual(1)
                );
    }

    public ElementsCollection getRemoveFromCartButtons() {
        return $$(removeFromCartButtonLocator)
                .shouldBe(CollectionCondition
                        .sizeGreaterThanOrEqual(1)
                );
    }

    public SelenideElement getAddToCartButton(String value) {
        return $("#" + value).shouldBe(Condition.visible);
    }

    public WebElement getRemoveFromCartButton(String value) {
        return $("#" + value).shouldBe(Condition.visible);
    }

    public Select selectMenu() {
        return new Select(getSortContainer());
    }
}
