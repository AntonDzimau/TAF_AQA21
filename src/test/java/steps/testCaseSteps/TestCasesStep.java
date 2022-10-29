package steps.testCaseSteps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.TestCasesPage;

public class TestCasesStep extends BaseStep {
    TestCasesPage testCasesPage;

    public TestCasesStep(WebDriver driver) {
        super(driver);
        testCasesPage = new TestCasesPage(driver);
    }

    @Step
    public void openPageByUrl() {
        testCasesPage.openPageByUrl();
    }

    @Step
    public void showReportDropDownMenu() {
        testCasesPage.getReportDropDown().showDropDownMenu();
    }

    @Step
    public void goToActivitySummaryPage() {
        testCasesPage.activitySummary().click();
    }

    @Step
    public void goToStatusTopsPage() {
        testCasesPage.statusTops().click();
    }

    @Step
    public void goToCoverageForReferencesPage() {
        testCasesPage.coverageForReferences().click();
    }

    @Step
    public void goToPropertyDistributionPage() {
        testCasesPage.propertyDistribution().click();
    }

}
