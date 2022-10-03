package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void validateIKTCalculationTest() {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement weight = driver.findElement(By.name("weight"));
        weight.sendKeys("58");
        WebElement height = driver.findElement(By.name("height"));
        height.sendKeys("178");
        WebElement button = driver.findElement(By.id("calc-mass-c"));
        button.click();
        WebElement iktResult = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(iktResult.getText(), "18.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateIKTNegativeCalculationTest() {
        driver.get("http://onliner.by");
/*        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        driver.findElement(By.name("weight"));*/
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
