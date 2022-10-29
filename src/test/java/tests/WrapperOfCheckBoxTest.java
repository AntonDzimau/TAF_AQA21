package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrapperOfCheckBoxTest extends BaseTest {

    @Test
    public void setShowAnnouncementTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.openPageByUrl();
        Assert.assertTrue(
                editProjectStep.setCheckBoxShowAnnouncement()
                        .isSelected());
    }

    @Test
    public void removeShowAnnouncementTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.openPageByUrl();
        editProjectStep.setCheckBoxShowAnnouncement();
        Assert.assertFalse(
                editProjectStep.removeCheckBoxShowAnnouncement()
                        .isSelected());
    }

}
