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

        if (browser != null && browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else if(browser != null && browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser != null && browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("nic");
        }
    }


    protected MainPage openMainPage(){
        System.out.println(reader);
        System.out.println(reader.getAppUrl());
        driver.get(reader.getAppUrl());
        return new MainPage(driver);
    }


    @AfterSuite(alwaysRun = true)
    protected void tearDownDriver(){
        driver.quit();
    }

}
