package services;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\01QA_Engineering\\projects\\TAF_AQA21\\src\\test\\resources\\chromedriver.exe");
        return new ChromeDriver(getChromeOptions());
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //режим отображать браузер или нет, в памяти компа он работает, но мы его не видим
        //ускоряет работу некоторых тестов, однако ДРУГИЕ тесты используют видимые части браузера
        //и с этим параметром могут упасть
        //значение внутри скобок - чтобы использовать настройки из пропертис джавы, дабы
        //не менять проект постоянно, когда нужно либо безэкранный режим либо экранный
        //а менять только файл config.properties
        chromeOptions.setHeadless(ReadProperties.isHeadless());
        /**аргументы Chrome*/
        //	Disables GPU hardware acceleration. If software renderer is not in place, then the GPU process won't launch
        chromeOptions.addArguments("--disable-gpu");

        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        //запуск в полноэкранном режиме
        chromeOptions.addArguments("--start-maximized");
        //запускает сразу приватный режим
        chromeOptions.addArguments("--incognito");
        return chromeOptions;
    }
}
