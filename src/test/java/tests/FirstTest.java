package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.AdvancedDriver;
import services.BrowsersService;
import services.SimpleDriver;

public class FirstTest {
    @Test
    public void simpleDriverTest() throws InterruptedException {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        //???как из интерфейса WebDriver создается объект
        Thread.sleep(1000); //на 1 секe появится драйвер
        driver.quit(); //и закроется
    }

    @Test
    public void advancedDriverTest() throws InterruptedException {
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void browsersServicesTest() throws InterruptedException {
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();
        Thread.sleep(5000);
        driver.quit();
    }
}
