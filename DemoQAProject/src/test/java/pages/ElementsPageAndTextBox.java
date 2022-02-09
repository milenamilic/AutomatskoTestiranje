package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPageAndTextBox {
    public WebDriver driver;
    public List<WebElement> sections;
    public WebElement fullName;
    public WebElement email;
    public WebElement currentAddress;
    public WebElement permanentAddress;
    public WebElement submitButton;
    public List<WebElement> textBoxOutput;

    public ElementsPageAndTextBox(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSections() {
        return driver.findElements(By.className("text"));
    }

    public WebElement getFullName() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddress() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public List<WebElement> getTextBoxOutput() {
        return driver.findElements(By.className("mb-1"));
    }
    //-----------------------------------------------------------

    public WebElement getEachSection (int i) {
        return getSections().get(i);
    }
    public void clickEachSection (int i) {
        getEachSection(i).click();
    }
    public void insertFullName (String fullName) {
        this.getFullName().clear();
        this.getFullName().sendKeys(fullName);
    }
    public void insertEmail (String email) {
        this.getEmail().clear();
        this.getEmail().sendKeys(email);
    }
    public void insertCurrentAddress (String currentAddress) {
        this.getCurrentAddress().clear();
        this.getCurrentAddress().sendKeys(currentAddress);
    }
    public void insertPermanentAddress (String permanentAddress) {
        this.getPermanentAddress().clear();
        this.getPermanentAddress().sendKeys(permanentAddress);
    }
    public void clickSubmit () {
        this.getSubmitButton().click();
    }

    public String getOutputText () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTextBoxOutput().size(); i++) {
            sb.append(getTextBoxOutput().get(i).getText());
            sb.append("\n");
        }
        return sb.toString();
    }

}
