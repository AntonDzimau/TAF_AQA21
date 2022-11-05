package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CataloguePage;

public class RemoveItemFromCartStep extends BaseStep {
    CataloguePage cataloguePage;
    CartPage cartPage;

    public RemoveItemFromCartStep(WebDriver driver) {
        super(driver);
        cataloguePage = new CataloguePage(driver);
        cartPage = new CartPage(driver);
    }

    @Step
    public CartPage removeItemFromCartPageAndOpenCart(String value) {
        for (int i = 0; i < cataloguePage.removeFromCartButtons.size(); i++) {
            if (cataloguePage.removeFromCartButtons.get(i).getAttribute("id").contains(value)) {
                cataloguePage.removeFromCartButtons.get(i).click();
            }
        }
        cataloguePage.headerPage.cartButton.click();
        return cartPage;
    }

}
