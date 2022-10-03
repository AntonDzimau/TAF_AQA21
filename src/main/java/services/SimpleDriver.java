package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SimpleDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\01QA_Engineering\\projects\\TAF_AQA21\\src\\test\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }
}
