package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.MainPage;

public class SetupTests {

    private PropertiesReader reader = new PropertiesReader();
    private static WebDriver driver;
    private String appUrl = "https://skleptest.pl/";

    @BeforeSuite
    protected void setupTests() {

        String browser = reader.getBrowser();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
    }


    protected MainPage openMainPage(){
        driver.get(reader.getAppUrl());
        return new MainPage(driver);
    }


    @AfterSuite(alwaysRun = true)
    protected void tearDownDriver(){
        driver.quit();
    }

}
