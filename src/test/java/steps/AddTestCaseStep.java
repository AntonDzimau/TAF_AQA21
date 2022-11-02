package steps;

import baseEntities.BaseStep;
import entities.TestCasesEntities;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.testCases.AddTestCasePage;
import pages.testCases.TestCaseDetailsPage;

public class AddTestCaseStep extends BaseStep {
    AddTestCasePage addTestCasePage;
    TestCasesEntities testCasesEntities;

    public AddTestCaseStep(WebDriver driver) {
        super(driver);
        addTestCasePage = new AddTestCasePage(driver);
        testCasesEntities = new TestCasesEntities();
    }

    @Step
    public void openPageByUrl() {
        addTestCasePage.openPageByUrl();
    }

    @Step
    public TestCaseDetailsPage createNewTestCaseByNumbers() {
        openPageByUrl();
        addTestCasePage.getTitleInput().sendKeys(testCasesEntities.testCase1.getTitle());
        addTestCasePage.getPreconditionsArea().sendKeys(testCasesEntities.testCase1.getPreconditions());
        addTestCasePage.getPriorityMenu().setOptionByNumber(testCasesEntities.testCase1.getPriorityValueNumber());
        addTestCasePage.getTypeMenu().setOptionByNumber(testCasesEntities.testCase1.getTypeValueNumber());
        addTestCasePage.getAcceptButton().click();
        return new TestCaseDetailsPage(driver);
    }

    @Step
    public TestCaseDetailsPage createNewTestCaseByNames() {
        openPageByUrl();
        addTestCasePage.getTitleInput().sendKeys(testCasesEntities.testCase2.getTitle());
        addTestCasePage.getPreconditionsArea().sendKeys(testCasesEntities.testCase2.getPreconditions());
        addTestCasePage.getPriorityMenu().setOptionByName(testCasesEntities.testCase2.getPriorityName());
        addTestCasePage.getTypeMenu().setOptionByName(testCasesEntities.testCase2.getTypeName());
        addTestCasePage.getAcceptButton().click();
        return new TestCaseDetailsPage(driver);
    }

    @Step
    public TestCaseDetailsPage createNewTestCaseByKeys() {
        openPageByUrl();
        addTestCasePage.getTitleInput().sendKeys(testCasesEntities.testCase3.getTitle());
        addTestCasePage.getPreconditionsArea().sendKeys(testCasesEntities.testCase3.getPreconditions());
        addTestCasePage.getPriorityMenu().setOptionByKeys(testCasesEntities.testCase3.getPriorityName());
        addTestCasePage.getTypeMenu().setOptionByKeys(testCasesEntities.testCase3.getTypeName());
        addTestCasePage.getAcceptButton().click();
        return new TestCaseDetailsPage(driver);
    }
}
