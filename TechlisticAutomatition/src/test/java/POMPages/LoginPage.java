package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {
    public WebDriver driver;
    WebElement firstName;
    WebElement lastName;
    List<WebElement> gender;
    List<WebElement> yearsOfExperience;
    WebElement date;
    List<WebElement> profession;
    List<WebElement> automationTools;
    WebElement continents;
    WebElement seleniumCommands;
    WebElement chooseFileButton;
    WebElement download;
    WebElement button;


    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getFirstName() {
        return driver.findElement(By.name("firstname"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.name("lastname"));
    }

    public List<WebElement> getGender() {
        return driver.findElements(By.name("sex"));
    }

    public List<WebElement> getYearsOfExperience() {
        return driver.findElements(By.name("exp"));
    }

    public WebElement getDate() {
        return driver.findElement(By.id("datepicker"));
    }

    public List<WebElement> getProfession() {
        return driver.findElements(By.name("profession"));
    }

    public List<WebElement> getAutomationTools() {
        return driver.findElements(By.name("tool"));
    }

    public WebElement getContinents() {
        return driver.findElement(By.id("continents"));
    }

    public WebElement getSeleniumCommands() {
        return driver.findElement(By.id("selenium_commands"));
    }

    public WebElement getChooseFileButton() {
        return driver.findElement(By.id("photo"));
    }

    public WebElement getDownload() {
        return driver.findElement(By.linkText("Click here to Download File"));
    }

    public WebElement getButton() {
        return driver.findElement(By.id("submit"));
    }

    public void insertFirstName (String firstName) {
        this.getFirstName().clear();
        this.getFirstName().sendKeys(firstName);
    }

    public void insertLastName (String lastName) {
        this.getLastName().clear();
        this.getLastName().sendKeys(lastName);
    }

    public void chooseGender (int i) {
            getGender().get(i).click();
    }

    public void chooseYearsOfExperience (int i) {
        getYearsOfExperience().get(i).click();
    }

    public void insertDate (String date) {
        this.getDate().clear();
        this.getDate().sendKeys(date);
    }

    public void chooseProfession (int i) {
        getProfession().get(i).click();
    }

    public void chooseAutomationTool (int i) {
        getAutomationTools().get(i).click();
    }



    public void selectAsia () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("Asia");
    }
    public void selectEurope () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("Europe");
    }
    public void selectAfrica () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("Africa");
    }
    public void selectAustralia () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("Australia");
    }
    public void selectSouthAmerica () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("South America");
    }
    public void selectNorthAmerica () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("North America");
    }
    public void selectNorthAntartica () {
        Select dropDown = new Select(getContinents());
        dropDown.selectByVisibleText("Antartica");
    }

    public void selectCommandsBrowser () {
        Select dropDown = new Select(getSeleniumCommands());
        dropDown.selectByVisibleText("Browser Commands");
    }
    public void selectCommandsNavigation () {
        Select dropDown = new Select(getSeleniumCommands());
        dropDown.selectByVisibleText("Navigation Commands");
    }
    public void selectCommandsSwitch () {
        Select dropDown = new Select(getSeleniumCommands());
        dropDown.selectByVisibleText("Switch Commands");
    }
    public void selectCommandsWait () {
        Select dropDown = new Select(getSeleniumCommands());
        dropDown.selectByVisibleText("Wait Commands");
    }

    public void selectCommandsWebEelement () {
        Select dropDown = new Select(getSeleniumCommands());
        dropDown.selectByVisibleText("WebElement Commands");
    }

    public void uploadImage () {
        this.getChooseFileButton().sendKeys("C:\\Users\\madao pi si\\Desktop\\mi.jpg");
    }

    public void download () {
        this.getDownload().click();
    }

    public void submit () {
        this.getButton().click();
    }
}
