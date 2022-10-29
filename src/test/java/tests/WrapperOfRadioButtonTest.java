package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrapperOfRadioButtonTest extends BaseTest {

    @Test
    public void setShowAnnouncementTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.openPageByUrl();
        Assert.assertTrue(
                editProjectStep.setCheckBoxShowAnnouncement()
                        .isSelected());
    }

    @Test
    public void setSecondTypeOfProjectByNameTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.openPageByUrl();
        Assert.assertTrue(
                editProjectStep.setTypeByName(2)
                        .isSelected());
    }

    @Test
    public void setThirdTypeOfProjectByRadioInputTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.openPageByUrl();
        Assert.assertTrue(
                editProjectStep.setTypeByRadioInput(3)
                        .isSelected());
    }

    @Test
    public void setFirstTypeOfProjectByPictureTest() {
        loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        editProjectStep.openPageByUrl();
        editProjectStep.setTypeByRadioInput(2);
        Assert.assertTrue(
                editProjectStep.setTypeByRadioInput(1)
                        .isSelected());
    }
}
