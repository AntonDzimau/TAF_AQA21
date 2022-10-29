package baseEntities;

import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.projectSteps.AddProjectStep;
import steps.reportsStep.ActivitySummaryStep;
import steps.projectSteps.EditProjectStep;
import steps.LoginStep;
import steps.testCaseSteps.TestCasesStep;
import utils.InvokedListener;


@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected AddProjectStep addProjectStep;
    protected EditProjectStep editProjectStep;
    protected TestCasesStep testCasesStep;
    protected ActivitySummaryStep activitySummaryStep;

    @BeforeMethod
    @Description("Настройка")
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        iTestContext.setAttribute("driver", driver);
        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
        addProjectStep = new AddProjectStep(driver);
        editProjectStep = new EditProjectStep(driver);
        testCasesStep = new TestCasesStep(driver);
        activitySummaryStep = new ActivitySummaryStep(driver);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
