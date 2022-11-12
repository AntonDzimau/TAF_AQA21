package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartLabelPage {
    private final By shoppingCartBadgeLocator = By.className("shopping_cart_badge");
    private final By cartButtonLocator = By.className("shopping_cart_link");

    public SelenideElement getShoppingCartBadge() {
        return $(shoppingCartBadgeLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getCartButton() {
        return $(cartButtonLocator).shouldBe(Condition.visible);
    }

}
