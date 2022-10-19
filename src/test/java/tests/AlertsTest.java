package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void infoAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        //кликаем по кнопке, которая вызывает алерт
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        //метод позволяет переключиться с текущего окна на куда-то, в данном случае на алерт
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        //нажать кнопку, отвечающую за принятие на алерте
        alert.accept();
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

    }

    @Test
    public void confirmationAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        alert = driver.switchTo().alert();

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");
    }

    @Test
    public void promptAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("sdgdsg");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: sdgdsg");
    }
}
