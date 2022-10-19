package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        //дожидаемся что все элементы figure отображены на странице
        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));

        Actions actions = new Actions(driver);
        actions
                //зажать клавишу SHIFT
                .keyDown(Keys.SHIFT)
                //отпустить клавишу SHIFT
                .keyUp(Keys.SHIFT)
                //передвигаем мышку к краю элемента верхний левый угол и смещает на 10 пикселей вниз и вправо
                .moveToElement(targetElements.get(0), 10, 10)
                //кликаем на элемент (ссылка) после проверки ее существоваения
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                //действия выше сразу не выполняются, собирается объект сначала
                .build()
                //выполняем после сборки с командами, которые были выше
                .perform();

        Assert.assertTrue(wait.waitForElementInvisible(targetElements.get(0)));
    }

    @Test
    public void fileUploadTest() throws InterruptedException, URISyntaxException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        //находим путь к файлу
        /**РАБОТА С ФАЙЛАМИ ИЗУЧАИТЬ*/
        //String pathToFile = ActionsTest.class.getClassLoader().getResource("doc1.png").toURI().getRawPath();
        String pathToFile = ActionsTest.class.getClassLoader().getResource("doc1.png").getPath();
        //удаление слэша в начале
       // String pathToFileFixed = pathToFile.substring(1, pathToFile.length());
        System.out.println(pathToFile);
        //fileUploadPath.sendKeys(pathToFileFixed);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }
}
