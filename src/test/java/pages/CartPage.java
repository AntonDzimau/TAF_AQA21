package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CartPage {
    private final static String pagePath = "cart.html";
    private final By continueShoppingButtonLocator = By.id("continue-shopping");
    private final By checkoutButtonLocator = By.id("checkout");
    private final By cartItemNameLocator = By.className("inventory_item_name");
    private final By cartLabelLocator = By.className("title");

    public void openPageByUrl() {
        open(pagePath);
    }

    public CataloguePage continueShopping() {
        $(continueShoppingButtonLocator).shouldBe(Condition.visible).click();
        return page(CataloguePage.class);
    }

    public CheckoutInfoPage checkout() {
        $(checkoutButtonLocator).shouldBe(Condition.visible).click();
        return page(CheckoutInfoPage.class);
    }

    public ElementsCollection getCartItemNames() {
        return $$(cartItemNameLocator).shouldBe(CollectionCondition.sizeGreaterThanOrEqual(0));
    }

    public void removeFromCart(String value) {
        $("#" + value).shouldBe(Condition.visible).click();
    }

    public SelenideElement getCartLabel() {
        return $(cartLabelLocator).shouldBe(Condition.visible);
    }
}
