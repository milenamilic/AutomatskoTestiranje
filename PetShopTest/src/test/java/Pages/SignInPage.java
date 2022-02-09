package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    public WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement login;
    WebElement welcomeMessage;
    WebElement signedInImage;
    WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.name("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getLogin() {
        return driver.findElement(By.name("signon"));
    }

    public WebElement getWelcomeMessage() {
        return driver.findElement(By.id("WelcomeContent"));
    }

    public WebElement getSignedInImage() {
        return driver.findElement(By.xpath("//*[@id=\"Banner\"]/img"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.className("messages"));
    }

    //--------------------------------------------------

    public void insertUsername (String correctUsername) {
        this.getUsername().clear();
        this.getUsername().sendKeys(correctUsername);
    }

    public void insertPassword (String correctPassword) {
        this.getPassword().clear();
        this.getPassword().sendKeys(correctPassword);
    }
    public void clickLogin () {
        this.getLogin().click();
    }
    public String welcomeMessageText () {

        return getWelcomeMessage().getText();
    }

    public String errorMessageText () {

        return getErrorMessage().getText();
    }
}
