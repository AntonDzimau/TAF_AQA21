package steps;

import baseEntities.BaseStep;
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

    public void addItemToCart(String value) {
        cataloguePage.getAddToCartButton(value).click();
    }

    public CartPage goToCartPage() {
        cataloguePage.cartLabelPage.clickCartButton();
        return cartPage;
    }

    public void addAllItemsToCart() {
        for (int i = cataloguePage.getAddToCartButton().size(); i > 0; i--) {
            cataloguePage.getAddToCartButton().get(0).click();
        }
    }

    public String getNameOfItemsInCart() {
        return cartPage.getCartItemName().getText();
    }

    public String getQuantityOfItemsInCartPage() {
        return cartPage.getCartItemNames().size() + "";
    }

    public String getQuantityOfItemsInCartLabel() {
        return cartPage.cartLabelPage.getShoppingCartBadge().getText();
    }

    public void removeItemFromCartPage(String value) {
        cataloguePage.getRemoveFromCartButton(value).click();
    }
}
