package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    public List<WebElement> pages;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getPages() {
        return driver.findElements(By.className("card-body"));
    }

    //--------------------------------------------------------------

    public WebElement getEachPage (int i) {
        return getPages().get(i);
    }
    public void clickEachPage (int i) {
        getEachPage(i).click();
    }

}
