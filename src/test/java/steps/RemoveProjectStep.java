package steps;

import baseEntities.BaseStep;
import entities.ProjectsEntities;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.projects.AddProjectPage;
import pages.projects.ListProjectsPage;

public class RemoveProjectStep extends BaseStep {
    ListProjectsPage listProjectsPage;
    ProjectsEntities projectsEntities;

    public RemoveProjectStep(WebDriver driver) {
        super(driver);
        listProjectsPage = new ListProjectsPage(driver);
        projectsEntities = new ProjectsEntities();
    }

    @Step
    public void openPageByUrl() {
        listProjectsPage.openPageByUrl();
    }

    @Step
    public ListProjectsPage removeProject(String nameOfProject) {
        openPageByUrl();
        listProjectsPage.getListOfProjects().getRow(nameOfProject).getCell(2).getLinkFromCell().click();
        listProjectsPage.getCheckboxForRemoval().setFlag();
        listProjectsPage.getAcceptRemovalButton().click();
        return new ListProjectsPage(driver);
    }

}
