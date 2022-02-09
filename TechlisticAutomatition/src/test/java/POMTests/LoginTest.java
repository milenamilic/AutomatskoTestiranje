package POMTests;

import POMBase.BasePage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

@BeforeMethod
    public void setUpPage () {
    driver.manage().window().maximize();
    driver.navigate().to(homeURL);
}

    @Test
    public void linkTest () {
    String actualText = driver.findElement(By.cssSelector(".post-title.entry-title")).getText();
    String expectedText = "Demo Sign-Up Selenium Automation Practice Form";
    }

    @Test
    public void verifyThatTheUserCanLogInWithValidCredentials () throws InterruptedException {

    for (int i = 1; i < 6; i++) {
        String firstName = excelReader.getStringData("Credentials", i, 0);
        String lastName = excelReader.getStringData("Credentials", i, 1);
        String data = excelReader.getStringData("Credentials", 1, 2);
        waiter(loginPage.getFirstName());
        loginPage.insertFirstName(firstName);
        loginPage.insertLastName(lastName);
        scroll(loginPage.getButton());
        loginPage.chooseGender(1);
        loginPage.chooseYearsOfExperience(0);
        loginPage.insertDate(data);
        loginPage.chooseProfession(1);
        loginPage.chooseAutomationTool(2);
        loginPage.selectEurope();
        loginPage.uploadImage();
        scroll(loginPage.getButton());
        waiter(loginPage.getDownload());
        loginPage.download();
        Thread.sleep(5000);
        driver.navigate().back();
        scroll(loginPage.getButton());
        waiter(loginPage.getButton());
        loginPage.submit();
    }


    }

    @Test
    public void click () throws InterruptedException {
    scroll(loginPage.getContinents());
    loginPage.selectAsia();
    Thread.sleep(2000);
    loginPage.selectCommandsSwitch();
    Thread.sleep(2000);
    loginPage.uploadImage();
    Thread.sleep(2000);
    loginPage.download();




    }


}
