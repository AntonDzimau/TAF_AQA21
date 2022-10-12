package BaseEntities;

import org.openqa.selenium.WebDriver;
import steps.LoginStep;

public class BaseStep {
    protected WebDriver driver;
    protected LoginStep loginStep;

    public BaseStep(WebDriver driver){
        this.driver = driver;
    }

}
