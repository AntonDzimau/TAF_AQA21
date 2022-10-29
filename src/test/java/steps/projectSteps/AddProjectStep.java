package steps.projectSteps;

import baseEntities.BaseStep;
import elements.RadioButtonOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;

public class AddProjectStep extends BaseStep {
    AddProjectPage addProjectPage;

    public AddProjectStep(WebDriver driver) {
        super(driver);
        addProjectPage = new AddProjectPage(driver);
    }

    @Step
    public void openPageByUrl() {
        addProjectPage.openPageByUrl();
    }

    @Step
    public String enterNameOfProject(String string) {
        addProjectPage.getNameInput().sendKeys(string);
        return addProjectPage.getNameInput().getText();
    }

    @Step
    public void removeNameOfProject() {
        addProjectPage.getNameInput().clear();
    }

    @Step
    public String enterAnnouncementOfProject(String string) {
        addProjectPage.getAnnouncementTextarea().sendKeys(string);
        return addProjectPage.getAnnouncementTextarea().getText();
    }

    @Step
    public void removeAnnouncementOfProject() {
        addProjectPage.getAnnouncementTextarea().clear();
    }

    @Step
    public void setCheckBoxShowAnnouncement() {
        addProjectPage.getShowAnnouncementCheckBox().setFlag();
    }

    @Step
    public void removeCheckBoxShowAnnouncement() {
        addProjectPage.getShowAnnouncementCheckBox().removeFlag();
    }

    private void setType(int numberOfType, String option) {
        switch (option) {
            case "radio":
                addProjectPage.getRadioButton().getRadioOption(numberOfType).setByRadioInput();
            case "name":
                addProjectPage.getRadioButton().getRadioOption(numberOfType).setByName();
            case "text":
                addProjectPage.getRadioButton().getRadioOption(numberOfType).setByText();
            case "picture":
                addProjectPage.getRadioButton().getRadioOption(numberOfType).setByPicture();
        }
    }

    @Step
    public RadioButtonOption setTypeByRadioInput(int numberOfType) {
        setType(numberOfType, "radio");
        return addProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public RadioButtonOption setTypeByName(int numberOfType) {
        setType(numberOfType, "name");
        return addProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public RadioButtonOption setTypeByTextarea(int numberOfType) {
        setType(numberOfType, "text");
        return addProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public RadioButtonOption setTypeByPicture(int numberOfType) {
        setType(numberOfType, "picture");
        return addProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public void accept() {
        addProjectPage.getAcceptButton().click();
    }

    @Step
    public void cancel() {
        addProjectPage.getCancelButton().click();
    }
}
