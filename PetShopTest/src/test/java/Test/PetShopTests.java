package Test;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PetShopTests extends BasePage {

    @BeforeMethod
    public void setUpPage () {
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }

    @Test
    public void testTheLink () {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = homeURL;
        Assert.assertEquals(actualURL, expectedURL);

        String actualSignInOption = driver.findElement(By.linkText("Sign In")).getText();
        String expectedSignInOption = "Sign In";
        Assert.assertEquals(actualSignInOption, expectedSignInOption);
    }

    @Test
    public void userCanRegisterWithAllFieldsFilledIn () {
        String validUserId = "2984";
        String validNewPassword = "Sta.god.123.*+.";
        String validFirstName = "Milan";
        String validLastName = "Ninkovic";
        String validEmail = "milan.ninkovic@gmail.com";
        String validPhone = "0695818179";
        String validAddress1 = "JNA 7";
        String validAddress2 = "Nesto 23";
        String validCity = "Kovin";
        String validState = "Nesto";
        String validZip = "11000";
        String validCountry = "Serbia";

        waiter(registrationPage.getSignInButton());
        registrationPage.clickSignIn();
        waiter(registrationPage.getRegisterNowButton());
        registrationPage.clickRegisterNow();
        waiter(registrationPage.getUserID());
        registrationPage.insertUserId(validUserId);
        registrationPage.insertNewPass(validNewPassword);
        registrationPage.insertRepeatPass(validNewPassword);
        registrationPage.insertfirstName(validFirstName);
        registrationPage.insertlastName(validLastName);
        registrationPage.insertEmail(validEmail);
        registrationPage.insertPhone(validPhone);
        registrationPage.insertAddress1(validAddress1);
        registrationPage.insertAddress2(validAddress2);
        registrationPage.insertCity(validCity);
        registrationPage.insertState(validState);
        registrationPage.insertZip(validZip);
        registrationPage.insertCountry(validCountry);
        scroll(registrationPage.getSaveAccount());
        registrationPage.chooseEnglish();
        registrationPage.chooseCategory();
        registrationPage.enableMyList();
        registrationPage.enableMyBanner();
        registrationPage.clickSaveAccount();

        //kada se registrujemo, sajt nas vraca na home page, pa ne mozemo da assertujemo da li smo registrovani
        //zato ce sam sign in zapravo biti assert za registraciju, posto ne bismo mogli da se sign inujemo
        //sa datim kredencijalima da nam nije napravljen nalog sa istima
    }

    @Test
    public void VerifyThatTheUserCanLogInWithCorrectCredentials () {
        //koristim iste kredencijale kao u prethodnom testu
        String correctUsername = "2984";
        String correctPassword = "Sta.god.123.*+.";

        waiter(registrationPage.getSignInButton());
        registrationPage.clickSignIn();
        waiter(signInPage.getUsername());

        //String actualURLBeforeSignIn = driver.getCurrentUrl();
        //String expectedURLBeforeSignIn = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
        //Assert.assertEquals(actualURLBeforeSignIn, expectedURLBeforeSignIn);

        signInPage.insertUsername(correctUsername);
        signInPage.insertPassword(correctPassword);
        signInPage.clickLogin();

        String actualWelcomeMessage = signInPage.welcomeMessageText();
        String expectedMessage = "Welcome Milan!";
        Assert.assertEquals(actualWelcomeMessage, expectedMessage);

        String actualURLafterSignIn = driver.getCurrentUrl();
        String expectedURLAfterSignIn = "https://petstore.octoperf.com/actions/Catalog.action";
        Assert.assertEquals(actualURLafterSignIn, expectedURLAfterSignIn);

        WebElement picture = signInPage.getSignedInImage();
        Assert.assertTrue(picture.isDisplayed());
        //ovaj assert radim posto slika ne postoji kada nismo sign in-ovani, a pojavljuje se
        //kada se sign in-ujemo uspesno

    }

    @Test
    public void userCannotLogInWithInvalidPassword () {

        waiter(registrationPage.getSignInButton());
        registrationPage.clickSignIn();
        String correctUsername = String.valueOf(excelReader.getIntegerData("Credentials", 1, 0));
        String incorrectPassword;

        for (int i = 1;  i < 7; i++) {
            incorrectPassword = excelReader.getStringData("Credentials", i, 3);


            waiter(signInPage.getUsername());

            signInPage.insertUsername(correctUsername);
            signInPage.insertPassword(incorrectPassword);
            signInPage.clickLogin();

            Assert.assertTrue(signInPage.getErrorMessage().isDisplayed());
            String actualErrorMessage = signInPage.errorMessageText();
            String expectedErrorMessage = "Invalid username or password. Signon failed.";
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        }


    }

}
