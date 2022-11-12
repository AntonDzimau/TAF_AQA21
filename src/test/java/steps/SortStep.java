package steps;

import io.qameta.allure.Step;
import pages.CataloguePage;

public class SortStep {
    CataloguePage cataloguePage;

    public SortStep() {
        cataloguePage = new CataloguePage();
    }

    @Step
    public CataloguePage setSortByAlphabet(String value) {
        cataloguePage.selectMenu().selectByValue(value);;
        return cataloguePage;
    }

    @Step
    public CataloguePage setSortByPrice(String value) {
        cataloguePage.selectMenu().selectByValue(value);
        return cataloguePage;
    }
}
