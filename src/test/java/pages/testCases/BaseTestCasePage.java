package pages.testCases;

import baseEntities.BasePage;
import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseTestCasePage extends BasePage {
    private final By titleInputLocator = By.id("title");
    private final By preconditionsAreaLocator = By.id("custom_preconds_display");
    private final By stepsAreaLocator = By.id("custom_steps_display");
    private final By expectedResultAreaLocator = By.id("custom_expected_display");
    private final By cancelButtonLocator = By.className("case-form-cancel");
    private final By prioritySelectLocator = By.id("priority_id");
    private final By priorityChosenTextLocator = By.cssSelector("div#priority_id_chzn span");


    public BaseTestCasePage(WebDriver driver) {
        super(driver);
    }


    public Input getTitleInput() {
        return new Input(driver, waitsService.waitForVisibilityBy(titleInputLocator));
    }

    public Textarea getPreconditionsArea() {
        return new Textarea(driver, waitsService.waitForVisibilityBy(preconditionsAreaLocator));
    }

    public DropDown getPrioritySelect() {
        return new DropDown(driver, waitsService.waitForVisibilityBy(prioritySelectLocator));
    }

    public Span getPriorityChosenText() {
        return new Span(driver, waitsService.waitForVisibilityBy(priorityChosenTextLocator));
    }

    public Button getCancelButton() {
        return new Button(driver, waitsService.waitForVisibilityBy(cancelButtonLocator));
    }


}
