package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import pages.testCases.AddTestCasePage;
import pages.testCases.TestCaseDetailsPage;

public class AddTestCaseStep extends BaseStep {
    AddTestCasePage addTestCasePage;

    public AddTestCaseStep(WebDriver driver) {
        super(driver);
        addTestCasePage = new AddTestCasePage(driver);
    }

    @Step
    public void openPageByUrl() {
        addTestCasePage.openPageByUrl();
    }

    @Step
    public TestCaseDetailsPage createNewTestCaseByNumbers() {
        TestCase testCase1 = new TestCase.Builder()
                .withTitle("Auto Test Case 1")
                .withPreconditions("Preconditions of Auto Test Case 1")
                .withPriority(1)
                .withType(0)
                .build();
        openPageByUrl();
        addTestCasePage.getTitleInput().sendKeys(testCase1.getTitle());
        addTestCasePage.getPreconditionsArea().sendKeys(testCase1.getPreconditions());
        addTestCasePage.getPriorityMenu().setOptionByNumber(testCase1.getPriorityValueNumber());
        addTestCasePage.getTypeMenu().setOptionByNumber(testCase1.getTypeValueNumber());
        addTestCasePage.getAcceptButton().click();
        return new TestCaseDetailsPage(driver);
    }

    @Step
    public TestCaseDetailsPage createNewTestCaseByNames() {
        TestCase testCase2 = new TestCase.Builder()
                .withTitle("Auto Test Case 2")
                .withPreconditions("Preconditions of Auto Test Case 2")
                .withPriority("Low")
                .withType("Security")
                .build();
        openPageByUrl();
        addTestCasePage.getTitleInput().sendKeys(testCase2.getTitle());
        addTestCasePage.getPreconditionsArea().sendKeys(testCase2.getPreconditions());
        addTestCasePage.getPriorityMenu().setOptionByName(testCase2.getPriorityName());
        addTestCasePage.getTypeMenu().setOptionByName(testCase2.getTypeName());
        addTestCasePage.getAcceptButton().click();
        return new TestCaseDetailsPage(driver);
    }

    @Step
    public TestCaseDetailsPage createNewTestCaseByKeys() {
        TestCase testCase3 = new TestCase.Builder()
                .withTitle("Auto Test Case 3")
                .withPreconditions("Preconditions of Auto Test Case 3")
                .withPriority("crit")
                .withType("au")
                .build();
        openPageByUrl();
        addTestCasePage.getTitleInput().sendKeys(testCase3.getTitle());
        addTestCasePage.getPreconditionsArea().sendKeys(testCase3.getPreconditions());
        addTestCasePage.getPriorityMenu().setOptionByKeys(testCase3.getPriorityName());
        addTestCasePage.getTypeMenu().setOptionByKeys(testCase3.getTypeName());
        addTestCasePage.getAcceptButton().click();
        return new TestCaseDetailsPage(driver);
    }
}
