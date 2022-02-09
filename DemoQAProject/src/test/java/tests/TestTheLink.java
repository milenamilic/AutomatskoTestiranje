package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTheLink extends BasePage {

    @Test
    public void verifyThatTheHomePageIsOpened () {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://demoqa.com/";
        Assert.assertEquals(actualURL, expectedURL);
    }
}
