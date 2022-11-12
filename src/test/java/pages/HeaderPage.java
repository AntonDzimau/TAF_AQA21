package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HeaderPage {
    private final By openBurgerMenuButtonLocator = By.id("react-burger-menu-btn");
    private final By shoppingCartBadgeLocator = By.className("shopping_cart_badge");
    private final By cartButtonLocator = By.className("shopping_cart_link");

    public TopMenuBurgerPage openBurgerMenu() {
        $(openBurgerMenuButtonLocator).shouldBe(Condition.visible).click();
        return page(TopMenuBurgerPage.class);
    }

    public CartPage openCart() {
        $(cartButtonLocator).shouldBe(Condition.visible).click();
        return page(CartPage.class);
    }

    public SelenideElement getShoppingCartBadge() {
        return $(shoppingCartBadgeLocator).shouldBe(Condition.visible);
    }
}
