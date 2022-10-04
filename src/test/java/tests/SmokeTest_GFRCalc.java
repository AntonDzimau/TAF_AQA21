package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import services.BrowsersService;

public class SmokeTest_GFRCalc {
    private WebDriver driver;

    @BeforeClass
    public void setUpAndFillingOutForms() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        Select select = new Select(driver.findElement(By.id("oSex")));
        select.selectByVisibleText("женский");
        WebElement creatinine = driver.findElement(By.id("oCr"));
        creatinine.sendKeys("80");
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys("55");
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys("163");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"Form1\"]/ul/li[6]/input[1]"));
        button.click();
    }

    @Test (priority = 1)
    public void checkMDRDTest() {
        WebElement MDRDResult = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(MDRDResult.getText(), "MDRD: 74 (мл/мин/1,73кв.м)","Wrong excepted result.");
    }

    @Test (priority = 2)
    public void checkCKDTest() {
        WebElement MDRDResult = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(MDRDResult.getText(), "ХБП: 1 стадия (при наличии почечного повреждения)", "Wrong excepted result.");
    }

    @Test (priority = 3)
    public void checkCGTest() {
        WebElement MDRDResult = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(MDRDResult.getText(), "Cockroft-Gault: 86 (мл/мин)", "Wrong excepted result.");
    }

    @Test (priority = 4)
    public void checkBSATest() {
        WebElement MDRDResult = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(MDRDResult.getText(), "Поверхность тела:1.58 (кв.м)", "Wrong excepted result.");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
