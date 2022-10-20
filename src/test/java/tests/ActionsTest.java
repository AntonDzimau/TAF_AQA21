package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ActionsTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement targetSquareBox = wait.waitForVisibilityBy(By.id("hot-spot"));
        actions
                .moveToElement(targetSquareBox, 10, 10)
                .contextClick()
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        Assert.assertTrue(targetSquareBox.isDisplayed());
    }

    @Test
    public void dynamicControlsCheckBoxTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        wait.waitForVisibilityBy(By.cssSelector("[label='blah']"));
        actions
                .click(wait.waitForVisibilityBy(By.cssSelector("[onclick='swapCheckbox()']")))
                .build()
                .perform();
        Assert.assertEquals(wait.waitForVisibilityBy(By.id("message")).getText(), "It's gone!");
    }

    @Test
    public void dynamicControlsInputTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement input = wait.waitForVisibilityBy(By.cssSelector("#input-example input"));
        Assert.assertFalse(input.isEnabled());
        actions
                .click(wait.waitForVisibilityBy(By.cssSelector("[onclick='swapInput()']")))
                .build()
                .perform();
        Assert.assertEquals(wait.waitForVisibilityBy(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(input.isEnabled());
    }

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.cssSelector("body p")).getText(), "Your content goes here.");
    }
}
