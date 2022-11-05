package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WaitsService {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WaitsService(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    //передаем в метод локатор элемента, отображение которого нам нужно проверить
    //метод будет считать определенное количество времени (в зависимости от конструктора)
    //и проверяет наличие элемета на странице:
    //1. элемент находится - проверяется виден ли он или нет (Displayd)
    //1.1. не виден, засыпаем на 500 мл -> виден - все ок - > возвращает вебэлемент
    //1.2. не нашло, то после 10 секунд (или того времени, которое мы указали в конструкторе
    //выкинет таймаут эксепш
    public WebElement waitForVisibilityBy(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //видимость по элементу
    public WebElement waitForVisibility(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //метод на проверку невидимости уже существующего элемента, найденного раньше
    public Boolean waitForElementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement fluentWaitForElement(By by) {
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                //через какое максимальное время выкинет эксепшн
                .withTimeout(Duration.ofSeconds(30))
                //как часто проверять условия (у explicitly -500 мс)
                .pollingEvery(Duration.ofMillis(50))
                //что игнорируем
                .ignoring(NoSuchElementException.class);
                //какое-то лямбда-выражение, ИЗУЧИТЬ
        return fluent.until(driver -> driver.findElement(by));
    }


}
