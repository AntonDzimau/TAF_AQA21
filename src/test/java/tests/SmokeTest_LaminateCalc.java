package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

    @Test(priority = 1)
    public void laminateCalcTest() {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Select selectLayingMethod = new Select(driver.findElement(By.id("laying_method_laminate")));
        selectLayingMethod.selectByVisibleText("с использованием отрезанного элемента");
        WebElement lengthRoom = driver.findElement(By.id("ln_room_id"));
        lengthRoom.clear();
        lengthRoom.sendKeys("500");
        WebElement widthRoom = driver.findElement(By.id("wd_room_id"));
        widthRoom.clear();
        widthRoom.sendKeys("400");
        WebElement lengthPanel = driver.findElement(By.id("ln_lam_id"));
        lengthPanel.clear();
        lengthPanel.sendKeys("2000");
        WebElement widthPanel = driver.findElement(By.id("wd_lam_id"));
        widthPanel.clear();
        widthPanel.sendKeys("200");
        WebElement directionLaminate = driver.findElement(By.id("direction-laminate-id1"));
        new Actions(driver).click(directionLaminate).perform();
        WebElement buttonCalc = driver.findElement(By.className("calc-btn"));
        buttonCalc.click();
        WebElement closePopUp = driver.findElement(By.className("mfp-close"));
        if (closePopUp.isDisplayed()) {
            closePopUp.click();
        }
       /* WebElement calcResult = driver.findElement(By.className("calc-result"));
        WebElement pint = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]/span"));
        System.out.println(pint.getText());
        System.out.println(pint.getAttribute("value"));*/
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
