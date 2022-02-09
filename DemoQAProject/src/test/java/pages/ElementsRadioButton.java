package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsRadioButton {
    public WebDriver driver;
    List<WebElement> radioButtons;
    List<WebElement> radioButtonLabel;
    WebElement message;
    WebElement yesRadioButton;
    WebElement impressiveRadioButton;
    WebElement noRadioButton;

    public ElementsRadioButton(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getRadioButtons() {
        return driver.findElements(By.className("custom-control-input"));
    }

    public List<WebElement> getRadioButtonLabel() {
        return driver.findElements(By.cssSelector("custom-control-label"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("mt-3"));
    }

    public WebElement getYesRadioButton() {
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getImpressiveRadioButton() {
        return driver.findElement(By.id("impressiveRadio"));
    }

    public WebElement getNoRadioButton() {
        return driver.findElement(By.id("noRadio"));
    }

    //---------------------------------------------------------------------

    public WebElement getEachRadioButton (int i) {
        return getRadioButtons().get(i);
    }
    public void clickEachRadioButton (int i) {
        getEachRadioButton(i).click();
    }

    public WebElement getEachRadioButtonLabel (int i) {
        return getRadioButtons().get(i);
    }
    public void clickEachRadioButtonLabel (int i) {
        getEachRadioButtonLabel(i).click();
    }

    public void clickYes () {
        getYesRadioButton().click();
    }

    public void clickImpressive () {
        getImpressiveRadioButton().click();
    }

    public void clickNo () {
        getNoRadioButton().click();
    }

}
