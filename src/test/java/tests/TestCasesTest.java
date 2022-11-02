package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.testCases.TestCaseDetailsPage;

public class TestCasesTest extends BaseTest {

    @Test
    public void createTestCaseByNumbersTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        addTestCaseStep.createNewTestCaseByNumbers();

        Assert.assertTrue(
                new TestCaseDetailsPage(driver).informationTable().getCell(0,"Priority").getText()
                        .contains("High"));

        Assert.assertTrue(
                new TestCaseDetailsPage(driver).informationTable().getCell(0,"Type").getText()
                        .contains("Acceptance"));
    }

    @Test
    public void createTestCaseByNamesTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        addTestCaseStep.createNewTestCaseByNames();

       Assert.assertTrue(
                new TestCaseDetailsPage(driver).informationTable().getCell(0,"Priority").getText()
                        .contains("Low"));

        Assert.assertTrue(
                new TestCaseDetailsPage(driver).informationTable().getCell(0,"Type").getText()
                        .contains("Security"));
    }

    @Test
    public void createTestCaseByKeysTest() throws InterruptedException {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        addTestCaseStep.createNewTestCaseByKeys();

        Assert.assertTrue(
                new TestCaseDetailsPage(driver).informationTable().getCell(0,"Priority").getText()
                        .contains("Critical"));

        Assert.assertTrue(
                new TestCaseDetailsPage(driver).informationTable().getCell(0,"Type").getText()
                        .contains("Automated"));
    }

}
