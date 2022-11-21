package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import entities.ProjectsEntities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.projects.ListProjectsPage;

public class ProjectsTest extends BaseTest {

    @Test (priority = 1)
    public void addNewProject2Test() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        addProjectStep.addNewProjectByRadioName();
        Assert.assertTrue(
                new ListProjectsPage(driver).getListOfProjects()
                        .isFoundInTable(new ProjectsEntities().testProject2.getName()));
    }

    @Test (priority = 1)
    public void addNewProject3Test() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        addProjectStep.addNewProjectByPicture();
        Assert.assertTrue(
                new ListProjectsPage(driver).getListOfProjects()
                        .isFoundInTable(new ProjectsEntities().testProject3.getName()));
    }

    @Test (priority = 2)
    public void removeProject2Test() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        removeProjectStep.removeProject(new ProjectsEntities().testProject2.getName());
        Assert.assertFalse(
                new ListProjectsPage(driver).getListOfProjects()
                        .isFoundInTable(new ProjectsEntities().testProject2.getName()));
    }

    @Test (priority = 2)
    public void removeProject3Test() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        removeProjectStep.removeProject(new ProjectsEntities().testProject3.getName());
        Assert.assertFalse(
                new ListProjectsPage(driver).getListOfProjects()
                        .isFoundInTable(new ProjectsEntities().testProject3.getName()));
    }

    @Test (priority = 2)
    public void removeAllProjectsTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        removeProjectStep.removeAllProjects();
        Assert.assertEquals(
                new ListProjectsPage(driver).getListOfProjects().getListOfRows().size()
                , 0);
    }

    @Test (priority = 3)
    public void editProjectTest1() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.editProject(
                "Czechau's Name of Project before editing",
                false,
                "Czechau's Name of Project after editing",
                "Announcement after editing");
        Assert.assertTrue(
                new ListProjectsPage(driver).getListOfProjects().isFoundInTable("Czechau's Name of Project after editing"));
    }

    @Test (priority = 4)
    public void editProjectTest2() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.editProject(
                "Czechau's Name of Project after editing",
                false,
                "Czechau's Name of Project before editing",
                "Announcement before editing");
        Assert.assertTrue(
                new ListProjectsPage(driver).getListOfProjects().isFoundInTable("Czechau's Name of Project before editing"));
    }
}
