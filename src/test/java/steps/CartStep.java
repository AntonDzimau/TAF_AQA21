package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.CataloguePage;

public class CartStep {
    CataloguePage cataloguePage;
    CartPage cartPage;

    public CartStep() {
        cartPage = new CartPage();
        cataloguePage = new CataloguePage();
    }

    @Step
    public CartPage addItemToCartAndGoToCart(String value) {
        cataloguePage.getAddToCartButton(value).click();
        cataloguePage.headerPage.openCart();
        return cartPage;
    }

    @Step
    public CataloguePage addItemToCart(String value) {
        cataloguePage.getAddToCartButton(value).click();
        return cataloguePage;
    }

    @Step
    public CartPage addAllItemsToCartAndGoToCart() {
        for (int i = cataloguePage.getAddToCartButtons().size(); i > 0; i--) {
            cataloguePage.getAddToCartButtons().get(0).click();
        }
        cataloguePage.headerPage.openCart();
        return cartPage;
    }

    @Step
    public CataloguePage addAllItemsToCart() {
        for (int i = cataloguePage.getAddToCartButtons().size(); i > 0; i--) {
            cataloguePage.getAddToCartButtons().get(0).click();
        }
        return cataloguePage;
    }

    @Step
    public CartPage removeItemFromCartPage(String value) {
        cataloguePage.getRemoveFromCartButton(value).click();
        return cartPage;
    }

    @Step
    public CartPage openCart() {
        cataloguePage.headerPage.openCart();
        return cartPage;
    }
}
