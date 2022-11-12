package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopMenuBurgerPage {
    private final By logoutLinkLocator = By.linkText("LOGOUT");
    private final By allItemsLinkLocator = By.linkText("ALL ITEMS");
    private final By closeBurgerMenuButtonLocator = By.id("react-burger-cross-btn");


    public void logout() {
        $(logoutLinkLocator).shouldBe(Condition.visible).click();
    }

    public void allItems() {
        $(allItemsLinkLocator).shouldBe(Condition.visible).click();
    }

    public void closeBurgerMenu() {
        $(closeBurgerMenuButtonLocator).shouldBe(Condition.visible).click();
    }
}
