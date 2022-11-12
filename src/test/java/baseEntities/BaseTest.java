package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.CartStep;
import steps.LoginStep;
import steps.SortStep;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public LoginStep loginStep;
    public CartStep cartStep;
    public SortStep sortStep;

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 8000;
        Configuration.fastSetValue = false;
        Configuration.browserSize = "1280x960";
        //Configuration.headless = true;
        //Configuration.reportsFolder = "target/";
    }

    @BeforeMethod
    public void setUpSteps() {
        loginStep = open("", LoginStep.class);
        cartStep = open("", CartStep.class);
        sortStep = open("", SortStep.class);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
