package pages.testCases;

import baseEntities.BasePage;
import elements.Button;
import elements.DropDown;
import elements.Input;
import elements.Textarea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseTestCasePage extends BasePage {
    private final By titleInputLocator = By.id("title");
    private final By preconditionsAreaLocator = By.id("custom_preconds_display");
    private final By stepsAreaLocator = By.id("custom_steps_display");
    private final By expectedResultAreaLocator = By.id("custom_expected_display");
    private final By cancelButtonLocator = By.className("case-form-cancel");
    private final By priorityMenuLocator = By.id("priority_id_chzn");
    private final By templateMenuLocator = By.id("template_id_chzn");
    private final By typeMenuLocator = By.id("type_id_chzn");
    private final By automationMenuLocator = By.id("custom_automation_type_chzn");

    public BaseTestCasePage(WebDriver driver) {
        super(driver);
    }

    public Input getTitleInput() {
        return new Input(driver, waitsService.waitForVisibilityBy(titleInputLocator));
    }

    public Textarea getPreconditionsArea() {
        return new Textarea(driver, waitsService.waitForVisibilityBy(preconditionsAreaLocator));
    }

    public DropDown getPriorityMenu() {
        return new DropDown(driver, waitsService.waitForVisibilityBy(priorityMenuLocator));
    }

    public DropDown getTemplateMenu() {
        return new DropDown(driver, waitsService.waitForVisibilityBy(templateMenuLocator));
    }

    public DropDown getTypeMenu() {
        return new DropDown(driver, waitsService.waitForVisibilityBy(typeMenuLocator));
    }

    public DropDown getAutomationMenu() {
        return new DropDown(driver, waitsService.waitForVisibilityBy(automationMenuLocator));
    }

    public Button getCancelButton() {
        return new Button(driver, waitsService.waitForVisibilityBy(cancelButtonLocator));
    }
}
