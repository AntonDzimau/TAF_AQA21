package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest_WarmFloorCalc {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test(priority = 1)
    public void warmFloorCalcTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = driver.findElement(By.id("el_f_width"));
        width.sendKeys("3");
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        length.sendKeys("4");
        Select selectRoom = new Select(driver.findElement(By.id("room_type")));
        selectRoom.selectByVisibleText("Кухня или спальня");
        Select selectHeatingType = new Select(driver.findElement(By.id("heating_type")));
        selectHeatingType.selectByVisibleText("Основное отопление");
        WebElement button = driver.findElement(By.name("button"));
        button.click();
        WebElement inputFloorPower = driver.findElement(By.id("floor_cable_power"));
        WebElement inputSpecFloorPower = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(inputFloorPower.getAttribute("value"), "1440", "Wrong excepted result.");
        Assert.assertEquals(inputSpecFloorPower.getAttribute("value"), "120", "Wrong excepted result.");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
