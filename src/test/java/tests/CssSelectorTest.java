package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class CssSelectorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @Test
    public void basicLocatorsTest() {
        driver.get("file:D:\\01QA_Engineering\\projects\\TAF_AQA21\\src\\test\\resources\\index.html");
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed());

        //Find by class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());

        //Find by multiple values of the "class" attribute
        Assert.assertTrue(driver.findElement(By.cssSelector(".noSel.newsletter")).isDisplayed());

        //Find by tag name + class name
        Assert.assertTrue(driver.findElement(By.cssSelector("p.noSel")).isDisplayed());

        //Find by class name with hierarchy
        Assert.assertEquals(driver.findElements(By.cssSelector("#Lastname .markup")).size(),2);

        //Find several elements by tag names
        Assert.assertEquals(driver.findElements(By.cssSelector("h1, p")).size(),8);

        //Find elements by parent/child
        Assert.assertEquals(driver.findElements(By.cssSelector("div > p")).size(),6);

        //Поиск элементов, которые находятся на одном уровне и сразу друг за другом
        Assert.assertEquals(driver.findElements(By.cssSelector("ul + p")).size(),1);

        //Поиск элементов, которые находятся на одном уровне (все дивы, которые находятся на уровне с п)
        Assert.assertEquals(driver.findElements(By.cssSelector("p ~ div")).size(),1);

        //Поиск по какому-то иному аттрибуту
        Assert.assertEquals( driver.findElements(By.cssSelector("[title]")).size(),1);

        //Поиск по конкретному значению стиля
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        //Поиск по аттрибуту значение которого заканчивается на
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        //Поиск по аттрибуту значение которого начинается на
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        //Поиск по аттрибуту, у которого присутствует какое-то значение (буква, слово)
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        //Поиск по аттрибуту, у которого присутствует какое-то слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*=beaut]")).size());

        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());
    }
}
