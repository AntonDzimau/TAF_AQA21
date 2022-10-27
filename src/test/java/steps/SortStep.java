package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.CataloguePage;
import pages.LoginPage;

public class SortStep extends BaseStep {
    CataloguePage cataloguePage;

    public SortStep(WebDriver driver) {
        super(driver);
        cataloguePage = new CataloguePage(driver);
    }

    public String setSortByAlphabet(String value) {
        cataloguePage.selectMenu().selectByValue(value);
        return cataloguePage.getFirstItemByName().getText();
    }

    public String setSortByPrice(String value) {
        cataloguePage.selectMenu().selectByValue(value);
        return cataloguePage.getFirstItemByPrice().getText();
    }
}
