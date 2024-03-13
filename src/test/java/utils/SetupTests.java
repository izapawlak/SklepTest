package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.MainPage;

public class SetupTests {

    private PropertiesReader reader = new PropertiesReader();
    private static WebDriver driver;
    private String appUrl = "https://skleptest.pl/";

    @BeforeSuite
    protected void setupTests(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected MainPage openMainPage(){
        driver.get(reader.getAppUrl());
        //napisać asercję
        return new MainPage(driver);
    }


    @AfterSuite(alwaysRun = true)
    protected void tearDownDriver(){
        driver.quit();
    }

}
