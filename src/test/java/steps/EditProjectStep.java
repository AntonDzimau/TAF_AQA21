package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.projects.EditProjectPage;
import pages.projects.ListProjectsPage;

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
    public ListProjectsPage editProject(boolean flagShowAnon, String newName, String newAnnouncement) {
        openPageByUrl();
        editProjectPage.getShowAnnouncementCheckBox().flag(flagShowAnon);
        editProjectPage.getNameInput().rewrite(newName);
        editProjectPage.getAnnouncementTextarea().rewrite(newAnnouncement);
        editProjectPage.getAcceptButton().click();
        return new ListProjectsPage(driver);
    }


}
