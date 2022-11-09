package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeSuite
    public void setUp(){
        //настройка allure скриншотов у Селенида
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                //создание скриншотов
                .screenshots(true)
                //сохранение ДОМ модели
                .savePageSource(true)
        );
        //какой браузер поднимать
        Configuration.browser = ReadProperties.browserName();
//дефолтный урл, который откроется при выполнении команды open
        Configuration.baseUrl = ReadProperties.getUrl();
        //изменяем дефолтный таймаут для ожидания
        Configuration.timeout = 8000;
        //быстрый ввод данных
        Configuration.fastSetValue = true;
        //запускать в невидимом режиме?
        //Configuration.headless = true;
        Configuration.browserSize = "1280x960";
        //Configuration.reportsFolder = "target/";
    }

    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }
}
