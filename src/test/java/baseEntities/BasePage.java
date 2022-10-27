package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.WaitsService;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver)  {
        this.driver = driver;
        waitsService = new WaitsService(driver);

        PageFactory.initElements(driver, this);
        //Анализатор того, что страница открылась или не открылась
        //Плохо работает с dependencyInjection, т.к. хз, херня какая-то
        //потому что страницы инициализируются разными классами и вообще могут быть не видны еще
        //и будет кидаться эксэпшн, но фрэймворк менее гибкий
/*        if (!isPageOpened()) {
            int i = 0;
            while (i < 30 && isPageOpened()) {
                Thread.sleep(1000);
            }
        }
        if (!isPageOpened()){
            throw new Exception("Page has not been opened");
        }*/
    }
    //Метод для проверки того, что страница открыта. Обычно выбирается элемент,
    //который загружается позже всего. И скорее всего элемент скорее всего будет
    //разный для каждой страницы, потому метод будет абстрактным.
    //Мы наследуемся от BasePage каждой страницей (LoginPage, DashboardPage), соответственно
    //мы должны реализовать абстрактный метод getPageIdentifier(), передав ему непосредственно
    //идентификатор конкретной страницы. Идентификатор отдастся родительскому BasePage, и она
    //сможет проверить отображается ли этот идентификатор на странице с помощью метода
    //isPageOpened()



    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
