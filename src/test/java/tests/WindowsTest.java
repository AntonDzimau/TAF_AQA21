package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @Test
    public void windowsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");
        String originalWindow = driver.getWindowHandle();
        System.out.println(originalWindow);
        driver.findElement(By.linkText("Click Here")).click();


        List<String> windowsHandlesList = new ArrayList<>(driver.getWindowHandles());

        System.out.println(windowsHandlesList.get(windowsHandlesList.size()-1));
        System.out.println(windowsHandlesList.get(windowsHandlesList.size()-2));
        driver.switchTo().window(windowsHandlesList.get(windowsHandlesList.size()-1));

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"New Window");

        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();
    }
}
