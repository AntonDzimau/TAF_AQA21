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
        new Select(cataloguePage.getSortContainer()).selectByValue(value);
        return cataloguePage.getFirstItemByName().getText();
    }

    public String setSortByPrice(String value) {
        new Select(cataloguePage.getSortContainer()).selectByValue(value);
        return cataloguePage.getFirstItemByPrice().getText();
    }
}
