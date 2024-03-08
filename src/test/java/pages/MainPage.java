package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {


    public MainPage(final WebDriver driver) {
        super(driver);
    }

    //Potwierdzenie wyświetlenia strony głównej
    public void isUrlCorrect() {
        driver.getCurrentUrl();
        assertEquals("https://skleptest.pl/", driver.getCurrentUrl());
    }

    //Przejście do Account
    @FindBy(className = "top-account")
    private WebElement topAccount;

    public AccountPage openAccountTab() { //dlaczego tutaj używam klasy Account page?
        topAccount.click();
        return new AccountPage(driver);
    }
}

//napisać metodę AccountPage ze sprawdzeniem
//metody statyczne nie mogą korzystać z pól niestatycznych
//ctrl + alt + o -> wywala niepotrzebne importy

