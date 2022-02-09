package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;
import java.util.List;

public class ElementsCheckBox {
    public WebDriver driver;
    WebElement plusSign;
    WebElement minusSign;
    WebElement homeArrowBefore;
    List<WebElement> allCheckBoxes;
    List<WebElement> message;
    List<WebElement> parentCheckboxes;


    public ElementsCheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPlusSign() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-expand-all"));
    }

    public WebElement getMinusSign() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-collapse-all"));
    }

    public WebElement getHomeArrowBefore() {
        return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
    }

    public List<WebElement> getAllCheckBoxes() {
        return driver.findElements(By.className("rct-checkbox"));
    }

    public List<WebElement> getMessage() {
        return driver.findElements(By.className("text-success"));
    }

    public List<WebElement> getParentCheckboxes() {
        return parentCheckboxes;
    }


    //-----------------------------------------------------------------------

    public void clickOnPlus () {
        this.getPlusSign().click();
    }
    public void clickMinusSign () {
        this.getMinusSign().click();
    }

    public WebElement getEachCheckBox (int i) {
        return this.getAllCheckBoxes().get(i);
    }

    public void tickEachCheckBox (int i) {
        this.getAllCheckBoxes().get(i).click();
    }
    public void clickOnHomeArrowSignBeforeItIsExpanded () {
        this.homeArrowBefore.click();
    }
    public void getMessageText (int i) {
        this.getMessage().get(i).getText();
    }

    public void getParticularMessage (int i) {
        this.getMessage().get(i);
    }

}
