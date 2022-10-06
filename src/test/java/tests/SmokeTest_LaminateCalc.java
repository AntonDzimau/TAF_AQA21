package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest_LaminateCalc {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test(priority = 1, invocationCount = 5)
    public void laminateCalcTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        driver.findElement(By.id("ln_room_id")).clear();
        driver.findElement(By.id("ln_room_id")).sendKeys("500");
        driver.findElement(By.id("wd_room_id")).clear();
        driver.findElement(By.id("wd_room_id")).sendKeys("400");
        driver.findElement(By.id("ln_lam_id")).clear();
        driver.findElement(By.id("ln_lam_id")).sendKeys("2000");
        driver.findElement(By.id("wd_lam_id")).clear();
        driver.findElement(By.id("wd_lam_id")).sendKeys("200");
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        new Select(driver.findElement(By.id("laying_method_laminate"))).selectByVisibleText("с использованием отрезанного элемента");
        driver.findElement(By.id("direction-laminate-id1")).click();
        driver.findElement(By.className("calc-btn")).click();
        if (driver.findElement(By.className("mfp-close")).isDisplayed()) {
            driver.findElement(By.className("mfp-close")).click();
        }
        Thread.sleep(670);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.calc-result span")).getText(),"53");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.calc-result > div ~ div > span")).getText(),"7");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
