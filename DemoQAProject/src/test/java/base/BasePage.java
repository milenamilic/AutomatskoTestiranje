package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.ElementsCheckBox;
import pages.ElementsPageAndTextBox;
import pages.ElementsRadioButton;
import pages.HomePage;

import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homeURL;
    public ElementsPageAndTextBox elementsPage;
    public HomePage homePage;
    public String elements;
    public String forms;
    public String alerts;
    public String widgets;
    public String interactions;
    public String bookStore;
    public ElementsCheckBox elementsCheckBox;
    public ElementsRadioButton elementsRadioButton;



    @BeforeClass
    public void setUp () throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("C:\\Users\\madao pi si\\IdeaProjects\\DemoQAProject\\DemoQA.xlsx");
        homeURL = excelReader.getStringData("Link", 1, 0);
        elementsPage = new ElementsPageAndTextBox(driver);
        homePage = new HomePage(driver);
        elements = excelReader.getStringData("Sections", 1, 0);
        forms = excelReader.getStringData("Sections", 2, 0);
        alerts = excelReader.getStringData("Sections", 3, 0);
        widgets = excelReader.getStringData("Sections", 4, 0);
        interactions = excelReader.getStringData("Sections", 5, 0);
        bookStore = excelReader.getStringData("Sections", 6, 0);
        elementsCheckBox = new ElementsCheckBox(driver);
        elementsRadioButton = new ElementsRadioButton(driver);

    }

    @BeforeMethod
    public void setUpPage () {
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }

    public void waiter (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scroll (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickB (WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @AfterClass
    public void tearDown () {
        //driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }
}
