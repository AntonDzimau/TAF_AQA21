package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.SimpleDriver;

public class FirstTest {
    @Test
    public void simpleDriverTest() throws InterruptedException {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        //???как из интерфейса WebDriver создается объект
        Thread.sleep(1000); //на 2 секи появится драйвер
        driver.quit(); //и закроется
    }
}
