package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        /*переключиться на найденный в ДОМ-модели элемент
        driver.switchTo().frame(frameElement);*/
        /*переключиться во фрейм 0-ой (по порядку)
        driver.switchTo().frame(0);*/
        //другой параметр переключения, возможно по НЭЙМ или АЙДИ
        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).isDisplayed();
        //переклюиться в родительский по отношению к iframe документ (то есть в документ, который непосрежственно содержит фрэйм
        //вложенность может быть глубокая, во фрэйме фрэйм, в нем еще один и т.д. эта команда вернет нас на 1 уровень выше
        //driver.switchTo().parentFrame();
        //а эта штука переключит нас в самый вообще что ни на есть начальный документ
        driver.switchTo().defaultContent();
        driver.findElement(By.tagName("h3")).isDisplayed();

    }
}
