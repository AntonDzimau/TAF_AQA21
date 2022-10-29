package steps.projectSteps;

import baseEntities.BaseStep;
import elements.CheckBox;
import elements.RadioButtonOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.projects.EditProjectPage;

public class EditProjectStep extends BaseStep {
    EditProjectPage editProjectPage;

    public EditProjectStep(WebDriver driver) {
        super(driver);
        editProjectPage = new EditProjectPage(driver);
    }

    @Step
    public void openPageByUrl() {
        editProjectPage.openPageByUrl();
    }

    @Step
    public String renameProject(String string) {
        editProjectPage.getNameInput().clear();
        editProjectPage.getNameInput().sendKeys(string);
        return editProjectPage.getNameInput().getText();
    }

    @Step
    public void removeNameOfProject() {
        editProjectPage.getNameInput().clear();
    }

    @Step
    public String enterAnnouncementOfProject(String string) {
        editProjectPage.getAnnouncementTextarea().sendKeys(string);
        return editProjectPage.getAnnouncementTextarea().getText();
    }

    @Step
    public void removeAnnouncementOfProject() {
        editProjectPage.getAnnouncementTextarea().clear();
    }

    @Step
    public CheckBox setCheckBoxShowAnnouncement() {
        editProjectPage.getShowAnnouncementCheckBox().setFlag();
        return editProjectPage.getShowAnnouncementCheckBox();
    }

    @Step
    public CheckBox removeCheckBoxShowAnnouncement() {
        editProjectPage.getShowAnnouncementCheckBox().removeFlag();
        return editProjectPage.getShowAnnouncementCheckBox();
    }

    @Step
    public void setCheckBoxProjectCompleted() {
        editProjectPage.getCompletedProjectCheckBox().setFlag();
    }

    @Step
    public void removeCheckBoxProjectCompleted() {
        editProjectPage.getCompletedProjectCheckBox().removeFlag();
    }

    private void setType(int numberOfType, String option) {
        switch (option) {
            case "radio":
                editProjectPage.getRadioButton().getRadioOption(numberOfType).setByRadioInput();
            case "name":
                editProjectPage.getRadioButton().getRadioOption(numberOfType).setByName();
            case "text":
                editProjectPage.getRadioButton().getRadioOption(numberOfType).setByText();
            case "picture":
                editProjectPage.getRadioButton().getRadioOption(numberOfType).setByPicture();
        }
    }

    @Step
    public RadioButtonOption setTypeByRadioInput(int numberOfType) {
        setType(numberOfType, "radio");
        return editProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public RadioButtonOption setTypeByName(int numberOfType) {
        setType(numberOfType, "name");
        return editProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public RadioButtonOption setTypeByTextarea(int numberOfType) {
        setType(numberOfType, "text");
        return editProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public RadioButtonOption setTypeByPicture(int numberOfType) {
        setType(numberOfType, "picture");
        return editProjectPage.getRadioButton().getRadioOption(numberOfType);
    }

    @Step
    public void accept() {
        editProjectPage.getAcceptButton().click();
    }

    @Step
    public void cancel() {
        editProjectPage.getCancelButton().click();
    }
}
