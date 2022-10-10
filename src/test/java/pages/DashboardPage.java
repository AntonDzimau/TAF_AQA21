package pages;

import BaseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DashboardPage extends BasePage {
    /**Блок описания селекторов для элементов*/
    private final static String pagePath = "index.php?/dashboard";
    private final By headerTitleLabelLocator = By.xpath("//div[contains(text(),'All Projects')]");
    public TopMenuPage topMenuPage;
    /**Блок инициализации страницы*/
    public DashboardPage(WebDriver driver) {
        super(driver);
        topMenuPage = new TopMenuPage(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByURL() {
        super.openPageByURL(pagePath);
    }

    /**Блок атомарных методов*/
    public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }

    /** С элементом Тайтл мы особо не взаимодействуем, нужен ли тут метод, который сразу
     * проверяет Дисплэйд или нет. Подход есть, можно использовать.
     */
    public boolean isHeaderTitleLabelDisplayed() {
        return driver.findElement(headerTitleLabelLocator).isDisplayed();
    }


}
