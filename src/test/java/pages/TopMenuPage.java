package pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TopMenuPage extends BasePage {
    /**Блок описания селекторов для элементов*/
    private final By pageIdentifier = By.xpath("???");

    /**Блок инициализации страницы*/
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected By getPageIdentifier() {
        return pageIdentifier;
    }

    /**Блок атомарных методов*/
    /*public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }*/

    /** С элементом Тайтл мы особо не взаимодействуем, нужен ли тут метод, который сразу
     * проверяет Дисплэйд или нет. Подход есть, можно использовать.
     */
/*    public boolean isHeaderTitleLabelDisplayed() {
        return driver.findElement(headerTitleLabelLocator).isDisplayed();
    }*/


}
