package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @Test(invocationCount = 5)
    public void taskEightTest() throws InterruptedException {
        //!By.id
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.usernameStandard());

        //!By.name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        //!CSS Selectors - .class1.class2
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        Thread.sleep(500);

        //!CSS Selectors - #id
        String nameInCatalogue = driver.findElement(By.cssSelector("#item_4_title_link div")).getText();
        System.out.println("The product name in the catalogue is " + nameInCatalogue);

        //!XPath - preceding-sibling
        String priceInCatalogue = driver.findElement(By.xpath("//button[@id = 'add-to-cart-sauce-labs-backpack']//preceding-sibling::div")).getText();
        System.out.println("The product price in the catalogue is " + priceInCatalogue);

        //!XPath - Поиск по атрибуту
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();

        //!By.className
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(500);

        //!CSS Selectors - tagname.class
        WebElement nameInCart = driver.findElement(By.cssSelector("div.inventory_item_name"));
        System.out.println("The name of the item in my cart is " + nameInCart.getText());

        //!CSS Selectors - .class
        WebElement priceInCart = driver.findElement(By.cssSelector(".inventory_item_price"));
        System.out.println("The price of the item in my cart is " + priceInCart.getText());

        Assert.assertEquals(nameInCatalogue, nameInCart.getText());
        Assert.assertEquals(priceInCatalogue, priceInCart.getText());

        //!XPath - Поиск элемента с условием AND, //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button' and @name='remove-sauce-labs-backpack']")).click();

        //!CSS Selectors - [attribute*=value]
        driver.findElement(By.cssSelector("[id*=burger-menu]")).click();
        Thread.sleep(500);

        //!By.linkText
        driver.findElement(By.linkText("All Items".toUpperCase())).click();
        Thread.sleep(500);

        //!XPath - Поиск по тексту
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();

        //!CSS Selectors - [attribute|=value]
        driver.findElement(By.cssSelector("[name|=back]")).click();
        Thread.sleep(500);

        //!CSS Selectors - .class1 .class2
        Assert.assertEquals(driver.findElements(By.cssSelector(".inventory_item_description .inventory_item_label")).size(), 6);

        //!XPath - ancestors
        System.out.println("Numbers of ancestors of logo is " + driver.findElements(By.xpath("//*[@class='app_logo']//ancestor::*")).size());

        //!XPath - descendant
        System.out.println(driver.findElements(By.xpath("//select[@class='product_sort_container']//descendant::option")).size() + " items to sort the catalogue.");

        //!XPath - following
        System.out.println("Numbers of following elements on page after <html> is " + driver.findElements(By.xpath("//html//following::*")).size());

        //!XPath - parent
        System.out.println("Number of parents of the 'header' element is " + driver.findElements(By.xpath("//div[@class='header_container']//parent::*")).size());

        //!CSS Selectors - [attribute$=value]
        driver.findElement(By.cssSelector("[id$=menu-btn]")).click();
        Thread.sleep(500);

        //!By.tagName
        if (driver.findElement(By.tagName("nav")).isDisplayed()) {
            System.out.println("Navigation panel is displayed.");
        } else {
            System.out.println("Navigation panel isn't displayed.");
        }

        //!By.partialLinkText
        driver.findElement(By.partialLinkText("Log".toUpperCase())).click();
        Thread.sleep(500);

        //!XPath - Поиск по частичному совпадению атрибута
        driver.findElement(By.xpath("//*[contains(@placeholder,'User')]")).sendKeys(ReadProperties.usernameLockedOut());
        driver.findElement(By.xpath("//*[contains(@placeholder,'Pass')]")).sendKeys(ReadProperties.password());
        driver.findElement(By.xpath("//*[contains(@name,'log')]")).click();

        //!XPath - Поиск по частичному совпадению текста
        driver.findElement(By.xpath("//*[contains(text(),'locked')]"));

        driver.findElement(By.cssSelector(".fa-times")).click();

        //!CSS Selectors - [attribute^=value]
        driver.findElement(By.cssSelector("[name^=user]")).clear();
        driver.findElement(By.cssSelector("[name^=user]")).sendKeys(ReadProperties.usernameStandard());

        //!CSS Selectors - [attribute=value]
        driver.findElement(By.cssSelector("[type='password']")).clear();
        driver.findElement(By.cssSelector("[type='password']")).sendKeys(ReadProperties.password());

        //!CSS Selectors - [attribute~=value]
        driver.findElement(By.cssSelector("[class~=submit-button]")).click();
        Thread.sleep(500);

        //!CSS Selectors - tagname
        System.out.println("Numbers of the <footer> is " + driver.findElements(By.cssSelector("footer")).size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
