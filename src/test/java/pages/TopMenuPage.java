package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage extends BasePage{
    //Ссылки для прямого доступа к ТОПМЕНЮ нет
    // 1. Блок описания селекторов для элементов
    //Один из них будет идентификатором открытия страницы
    private final By pageIdentifier = By.xpath("");

    // 2. Блок инициализации страницы
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }


    // 3. Блок атомарных методов
/*    public WebElement getHeaderLogo() {
       return driver.findElement(headerLogoLocator);
    }*/

    //!!! Подход, когда проверка наличия описывается в атомарном методе на странице
/*    public boolean isHeaderLogoLocator() {
       return getHeaderLogo().isDisplayed();
    }*/


}
