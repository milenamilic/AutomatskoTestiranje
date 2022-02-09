package POMBase;

import POMPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public String homeURL;


    @BeforeClass
    public void setUp () throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginPage = new LoginPage(driver);
        excelReader = new ExcelReader("C:\\Users\\madao pi si\\IdeaProjects\\TechlisticAutomatition\\Data for automatition.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
    }

    public void waiter (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void getLastRow () {
    }


    @AfterClass
    public void tearDown () {
        //driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }
}
