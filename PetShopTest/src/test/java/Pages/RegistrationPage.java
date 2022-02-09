package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    public WebDriver driver;
    WebElement signInButton;
    WebElement registerNowButton;
    WebElement userID;
    WebElement newPassword;
    WebElement repeatPassword;
    WebElement firstName;
    WebElement lastName;
    WebElement email;
    WebElement phone;
    WebElement address1;
    WebElement address2;
    WebElement city;
    WebElement state;
    WebElement zip;
    WebElement country;
    WebElement language;
    WebElement favouriteCategory;
    WebElement myList;
    WebElement myBanner;
    WebElement saveAccount;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignInButton() {
        return driver.findElement(By.linkText("Sign In"));
    }

    public WebElement getRegisterNowButton() {
        return driver.findElement(By.linkText("Register Now!"));
    }

    public WebElement getUserID() {
        return driver.findElement(By.name("username"));
    }

    public WebElement getNewPassword() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getRepeatPassword() {
        return driver.findElement(By.name("repeatedPassword"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.name("account.firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.name("account.lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.name("account.email"));
    }

    public WebElement getPhone() {
        return driver.findElement(By.name("account.phone"));
    }

    public WebElement getAddress1() {
        return driver.findElement(By.name("account.address1"));
    }

    public WebElement getAddress2() {
        return driver.findElement(By.name("account.address2"));
    }

    public WebElement getCity() {
        return driver.findElement(By.name("account.city"));
    }

    public WebElement getState() {
        return driver.findElement(By.name("account.state"));
    }

    public WebElement getZip() {
        return driver.findElement(By.name("account.zip"));
    }

    public WebElement getCountry() {
        return driver.findElement(By.name("account.country"));
    }

    public WebElement getLanguage() {
        return driver.findElement(By.name("account.languagePreference"));
    }

    public WebElement getFavouriteCategory() {
        return driver.findElement(By.name("account.favouriteCategoryId"));
    }

    public WebElement getMyList() {
        return driver.findElement(By.name("account.listOption"));
    }

    public WebElement getMyBanner() {
        return driver.findElement(By.name("account.bannerOption"));
    }

    public WebElement getSaveAccount() {
        return driver.findElement(By.name("newAccount"));
    }

    //--------------------------------------------------------

    public void clickSignIn () {
        this.getSignInButton().click();
    }
    public void clickRegisterNow () {
        this.getRegisterNowButton().click();
    }

    public void insertUserId (String userID) {
        this.getUserID().clear();
        this.getUserID().sendKeys(userID);
    }

    public void insertNewPass (String newPass) {
        this.getNewPassword().clear();
        this.getNewPassword().sendKeys(newPass);
    }

    public void insertRepeatPass (String repeatPass) {
        this.getRepeatPassword().clear();
        this.getRepeatPassword().sendKeys(repeatPass);
    }

    public void insertfirstName (String firstName) {
        this.getFirstName().clear();
        this.getFirstName().sendKeys(firstName);
    }

    public void insertlastName (String lastName) {
        this.getLastName().clear();
        this.getLastName().sendKeys(lastName);
    }

    public void insertEmail (String email) {
        this.getEmail().clear();
        this.getEmail().sendKeys(email);
    }

    public void insertPhone (String phone) {
        this.getPhone().clear();
        this.getPhone().sendKeys(phone);
    }
    public void insertAddress1 (String address1) {
        this.getAddress1().clear();
        this.getAddress1().sendKeys(address1);
    }

    public void insertAddress2 (String address2) {
        this.getAddress2().clear();
        this.getAddress2().sendKeys(address2);
    }

    public void insertCity (String city) {
        this.getCity().clear();
        this.getCity().sendKeys(city);
    }

    public void insertState (String state) {
        this.getState().clear();
        this.getState().sendKeys(state);
    }
    public void insertZip (String zip) {
        this.getZip().clear();
        this.getZip().sendKeys(zip);
    }

    public void insertCountry (String country) {
        this.getCountry().clear();
        this.getCountry().sendKeys(country);
    }

    public void chooseEnglish () {
        Select dropDropdown = new Select(getLanguage());
        dropDropdown.selectByVisibleText("english");
    }
    public void chooseCategory () {
        Select dropDropdown = new Select(getFavouriteCategory());
        dropDropdown.selectByVisibleText("BIRDS");
    }
    public void enableMyList () {
        this.getMyList().click();
    }
    public void enableMyBanner () {
        this.getMyBanner().click();
    }
    public void clickSaveAccount () {
        this.getSaveAccount().click();
    }

}
