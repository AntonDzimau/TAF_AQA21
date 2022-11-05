package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CataloguePage;

public class AddItemToCartStep extends BaseStep {
    CataloguePage cataloguePage;
    CartPage cartPage;

    public AddItemToCartStep(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
        cataloguePage = new CataloguePage(driver);
    }

    @Step
    public CartPage addItemToCartAndOpenCart(String value) {
        for (int i = 0; i < cataloguePage.addToCartButtons.size(); i++) {
            if (cataloguePage.addToCartButtons.get(i).getAttribute("id").contains(value)) {
                cataloguePage.addToCartButtons.get(i).click();
            }
        }
        cataloguePage.headerPage.openCart();
        return cartPage;
    }

    @Step
    public CartPage addAllItemsToCartAndOpenCart() {
        for (int i = cataloguePage.addToCartButtons.size(); i > 0; i--) {
            cataloguePage.addToCartButtons.get(0).click();
        }
        cataloguePage.headerPage.openCart();
        return cartPage;
    }
/*
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
    }*/
}
