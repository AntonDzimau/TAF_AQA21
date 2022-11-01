package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.DropDown;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.testCases.TestCaseDetailsPage;

public class WrapperOfDropDownTest extends BaseTest {

    @Test
    public void createProjectByNumbersTest() {
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
    public void createProjectByNamesTest() {
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
    public void createProjectByKeysTest() throws InterruptedException {
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
