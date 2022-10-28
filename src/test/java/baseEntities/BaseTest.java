package baseEntities;

import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.CartStep;
import steps.LoginStep;
import steps.SortStep;
import utils.InvokedListener;


@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected SortStep sortStep;
    protected CartStep cartStep;

    @BeforeMethod
    @Description("Настройка")
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        iTestContext.setAttribute("driver", driver);
        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
        sortStep = new SortStep(driver);
        cartStep = new CartStep(driver);
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
