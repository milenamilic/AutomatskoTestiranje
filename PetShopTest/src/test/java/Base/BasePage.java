package Base;

import Pages.RegistrationPage;
import Pages.SignInPage;
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
    public ExcelReader excelReader;
    public String homeURL;
    public RegistrationPage registrationPage;
    public SignInPage signInPage;


    @BeforeClass
    public void setUp () throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("C:\\Users\\madao pi si\\IdeaProjects\\PetShopTest\\src\\PetStoreExcel.xlsx");
        homeURL = excelReader.getStringData("Link", 1, 0);
        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver);

    }

    public void waiter (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scroll (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    @AfterClass
    public void tearDown () {
        //driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }

}
