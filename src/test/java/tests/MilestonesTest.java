package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import entities.ProjectsEntities;
import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.projects.ListProjectsPage;

public class MilestonesTest extends BaseTest {

    @Test (priority = 1)
    public void addNewMilestoneTest() {
        Milestone milestone1 = new Milestone();
        milestone1.setName("Milestone test name");
        milestone1.setCompleted(false);
        milestone1.setReferences("Some reference.");
        milestone1.setDescription("Some description.");
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(
                addMilestoneStep
                        .createMilestone(milestone1).getPageHeaderTitle().isDisplayed());
    }
}
