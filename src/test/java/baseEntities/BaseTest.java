package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.LoginStep;


//@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        this.setDriverToContext(iTestContext, driver);

        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
    }

    @AfterMethod
    public void TearDown() {

        driver.quit();
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }

}
