package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CataloguePage;

public class CartStep extends BaseStep {
    CataloguePage cataloguePage;
    CartPage cartPage;

    public CartStep(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
        cataloguePage = new CataloguePage(driver);
    }

    @Step
    public void addItemToCart(String value) {
        cataloguePage.getAddToCartButton(value).click();
    }

    @Step
    public CartPage goToCartPage() {
        cataloguePage.cartLabelPage.clickCartButton();
        return cartPage;
    }

    @Step
    public void addAllItemsToCart() {
        for (int i = cataloguePage.getAddToCartButton().size(); i > 0; i--) {
            cataloguePage.getAddToCartButton().get(0).click();
        }
    }

    @Step
    public String getNameOfItemsInCart() {
        return cartPage.getCartItemName().getText();
    }

    @Step
    public String getQuantityOfItemsInCartPage() {
        return cartPage.getCartItemNames().size() + "";
    }

    @Step
    public String getQuantityOfItemsInCartLabel() {
        return cartPage.cartLabelPage.getShoppingCartBadge().getText();
    }

    @Step
    public void removeItemFromCartPage(String value) {
        cataloguePage.getRemoveFromCartButton(value).click();
    }
}
