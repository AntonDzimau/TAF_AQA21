package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;

public class SortStep extends BaseStep {
    CataloguePage cataloguePage;

    public SortStep(WebDriver driver) {
        super(driver);
        cataloguePage = new CataloguePage(driver);
    }

    @Step
    public String setSortByAlphabet(String value) {
        cataloguePage.selectMenu().selectByValue(value);
        return cataloguePage.getFirstItemByName().getText();
    }

    @Step
    public String setSortByPrice(String value) {
        cataloguePage.selectMenu().selectByValue(value);
        return cataloguePage.getFirstItemByPrice().getText();
    }
}
