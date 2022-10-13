package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод для проверки того, что страница открыта. Обычно выбирается элемент,
    //который загружается позже всего. И скорее всего элемент скорее всего будет
    //разный для каждой страницы, потому метод будет абстрактным.
    //Мы наследуемся от BasePage каждой страницей (LoginPage, DashboardPage), соответственно
    //мы должны реализовать абстрактный метод getPageIdentifier(), передав ему непосредственно
    //идентификатор конкретной страницы. Идентификатор отдастся родительскому BasePage, и она
    //сможет проверить отображается ли этот идентификатор на странице с помощью метода
    //isPageOpened()
    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
